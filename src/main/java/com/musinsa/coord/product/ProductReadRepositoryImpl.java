package com.musinsa.coord.product;

import com.musinsa.coord.common.repository.JooqTools;
import com.musinsa.coord.product.dto.ProductResponse;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Records;
import org.jooq.SelectField;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.musinsa.coord.Tables.*;
import static org.jooq.impl.DSL.*;

@Repository
public class ProductReadRepositoryImpl implements ProductReadRepository {

    private DSLContext ctx;

    public ProductReadRepositoryImpl(DSLContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public Page<ProductResponse> findAllWithVariants(Pageable pageable) {
        List<ProductResponse> list = ctx.select(
                    PRODUCT.ID,
                    brand(),
                    category(),
                    productVariants(),
                    PRODUCT.NAME,
                    PRODUCT.CODE,
                    PRODUCT.PRICE
                ).from(PRODUCT)
                .innerJoin(BRAND).on(BRAND.ID.eq(PRODUCT.BRAND_ID))
                .innerJoin(CATEGORY).on(CATEGORY.ID.eq(PRODUCT.CATEGORY_ID))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch()
                .map(Records.mapping(ProductResponse::new));
        Long totalElements = ctx.selectCount().from(PRODUCT)
                .innerJoin(BRAND).on(BRAND.ID.eq(PRODUCT.BRAND_ID))
                .innerJoin(CATEGORY).on(CATEGORY.ID.eq(PRODUCT.CATEGORY_ID))
                .fetchOneInto(Long.class);
        return JooqTools.buildPage(list, pageable, totalElements);
    }

    private SelectField<ProductResponse.Brand> brand() {
        return row(BRAND.ID, BRAND.NAME).mapping(ProductResponse.Brand::new).as("brand");
    }

    private SelectField<ProductResponse.Category> category() {
        return row(CATEGORY.ID, CATEGORY.NAME).mapping(ProductResponse.Category::new).as("category");
    }

    private Field<List<ProductResponse.ProductVariant>> productVariants() {
        return multiset(
                select(
                        PRODUCT_VARIANT.ID,
                        PRODUCT_VARIANT.COLOR,
                        PRODUCT_VARIANT.SIZE
                ).from(PRODUCT_VARIANT)
                 .where(PRODUCT_VARIANT.PRODUCT_ID.eq(PRODUCT.ID))
        ).convertFrom(r -> r.map(Records.mapping(ProductResponse.ProductVariant::new)))
         .as("productVariants");
    }

}
