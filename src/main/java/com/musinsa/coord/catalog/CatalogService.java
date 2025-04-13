package com.musinsa.coord.catalog;

import com.musinsa.coord.catalog.dto.*;
import com.musinsa.coord.common.error.exception.BusinessException;
import com.musinsa.coord.common.error.exception.ErrorCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    private CatalogRepository catalogRepository;

    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public CheapestProductByCategoryResponse findCheapestProductSelectionSummary() {
        List<CheapestProductByCategory> selections = catalogRepository.findCheapestProductPerCategory();
        int totalPrice = selections.stream()
                .mapToInt(CheapestProductByCategory::price)
                .sum();
        return new CheapestProductByCategoryResponse(selections, totalPrice);
    }

    public CheapestProductByBrandResponse findCheapestProductBrand() {
        CheapestProductByBrand cheapestBrand = catalogRepository.findCheapestBrand();
        return new CheapestProductByBrandResponse(cheapestBrand);
    }

    public MinMaxPriceByCategoryResponse findMinMaxPriceByCategory(String categoryName) {
        if (!catalogRepository.categoryExistsByName(categoryName)) {
           throw new BusinessException(ErrorCode.RESOURCE_NOT_FOUND, "categoryName " + categoryName + " doesn't exist");
        }
        MinMaxPrice minMaxPriceByCategory = catalogRepository.findMinMaxPriceByCategory(categoryName);
        List<ProductPrice> minPrices = catalogRepository.findProductPriceByCategoryAndPrice(categoryName, minMaxPriceByCategory.minPrice());
        List<ProductPrice> maxPrices = catalogRepository.findProductPriceByCategoryAndPrice(categoryName, minMaxPriceByCategory.maxPrice());
        return new MinMaxPriceByCategoryResponse(categoryName, minPrices, maxPrices);
    }

}
