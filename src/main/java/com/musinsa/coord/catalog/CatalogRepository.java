package com.musinsa.coord.catalog;

import com.musinsa.coord.catalog.dto.*;
import org.jooq.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

import static com.musinsa.coord.Tables.*;
import static org.jooq.impl.DSL.*;

@Repository
public class CatalogRepository {

    private DSLContext ctx;

    public CatalogRepository(DSLContext ctx) {
        this.ctx = ctx;
    }

    public List<CheapestProductByCategory> findCheapestProductPerCategory() {
        var minPricePerCategory = select(
                PRODUCT.CATEGORY_ID,
                min(PRODUCT.PRICE).as("min_price")
        ).from(PRODUCT)
        .groupBy(PRODUCT.CATEGORY_ID)
        .asTable("min_price_per_category");
        // Alias for the inner subquery in the extra join condition
        var altProduct = PRODUCT.as("alt_product");
        return ctx.select(
                    CATEGORY.NAME,
                    BRAND.NAME,
                    PRODUCT.PRICE
                 )
                .from(minPricePerCategory)
                .innerJoin(PRODUCT)
                .on(PRODUCT.CATEGORY_ID.eq(minPricePerCategory.field(PRODUCT.CATEGORY_ID)))
                .and(PRODUCT.PRICE.eq(minPricePerCategory.field("min_price", Integer.class)))
                // Select product with min ID ff there are multiple same min price products
                .and(PRODUCT.ID.eq(
                        select(min(altProduct.field(PRODUCT.ID)))
                        .from(altProduct)
                        .where(altProduct.field(PRODUCT.CATEGORY_ID).eq(PRODUCT.CATEGORY_ID))
                        .and(altProduct.field(PRODUCT.PRICE).eq(minPricePerCategory.field("min_price", Integer.class)))
                 ))
                .innerJoin(BRAND).on(PRODUCT.BRAND_ID.eq(BRAND.ID))
                .innerJoin(CATEGORY).on(PRODUCT.CATEGORY_ID.eq(CATEGORY.ID))
                .fetch()
                .map(Records.mapping(CheapestProductByCategory::new));
    }

    public CheapestProductByBrand findCheapestBrand() {
        Record3<Long, String, BigDecimal> brandIdNameTotalPrice = ctx.select(
                        PRODUCT.BRAND_ID,
                        BRAND.NAME,
                        sum(PRODUCT.PRICE).as("total_price")
                ).from(PRODUCT)
                .innerJoin(BRAND).on(PRODUCT.BRAND_ID.eq(BRAND.ID))
                .groupBy(PRODUCT.BRAND_ID)
                .orderBy(sum(PRODUCT.PRICE).as("total_price").asc())
                .limit(1)
                .fetchOne();
        Long brandId = brandIdNameTotalPrice.component1();
        String brandName = brandIdNameTotalPrice.component2();
        Integer totalPrice = brandIdNameTotalPrice.component3().intValue();
        List<CheapestProductByBrand.CategoryPrice> categoryPrices = ctx.select(CATEGORY.NAME, PRODUCT.PRICE)
                .from(PRODUCT)
                .innerJoin(CATEGORY).on(PRODUCT.CATEGORY_ID.eq(CATEGORY.ID))
                .innerJoin(BRAND).on(PRODUCT.BRAND_ID.eq(BRAND.ID))
                .where(BRAND.ID.eq(brandId))
                .fetch()
                .map(Records.mapping(CheapestProductByBrand.CategoryPrice::new));
        return new CheapestProductByBrand(brandName, categoryPrices, totalPrice);
    }

    public MinMaxPrice findMinMaxPriceByCategory(String categoryName) {
         return ctx.select(
                min(PRODUCT.PRICE).as("min_price"),
                max(PRODUCT.PRICE).as("max_price")
        )
        .from(PRODUCT)
        .innerJoin(CATEGORY).on(PRODUCT.CATEGORY_ID.eq(CATEGORY.ID))
        .where(CATEGORY.NAME.eq(categoryName))
        .fetchOneInto(MinMaxPrice.class);
    }

    public List<ProductPrice> findProductPriceByCategoryAndPrice(String categoryName, Integer price) {
        return ctx.select(
                PRODUCT.ID,
                BRAND.NAME.as("brand_name"),
                PRODUCT.PRICE
        )
        .from(PRODUCT)
        .innerJoin(BRAND).on(PRODUCT.BRAND_ID.eq(BRAND.ID))
        .innerJoin(CATEGORY).on(PRODUCT.CATEGORY_ID.eq(CATEGORY.ID))
        .where(CATEGORY.NAME.eq(categoryName)
                .and(PRODUCT.PRICE.eq(price)))
        .fetch()
        .map(Records.mapping(ProductPrice::new));
    }

    public boolean categoryExistsByName(String categoryName) {
        return ctx.fetchExists(select(CATEGORY.NAME).from(CATEGORY).where(CATEGORY.NAME.eq(categoryName)));
    }

}
