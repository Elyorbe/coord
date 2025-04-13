package com.musinsa.coord.catalog;

import com.musinsa.coord.catalog.dto.CheapestProductByBrandResponse;
import com.musinsa.coord.catalog.dto.CheapestProductByCategoryResponse;
import com.musinsa.coord.catalog.dto.MinMaxPriceByCategoryResponse;
import com.musinsa.coord.common.error.exception.BusinessException;
import com.musinsa.coord.common.error.exception.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogController {

    private CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;

    }

    @GetMapping("/cheapest-per-category")
    ResponseEntity<CheapestProductByCategoryResponse> fetchCheapestPerCategory() {
        CheapestProductByCategoryResponse cheapestProductSelectionSummary = catalogService.findCheapestProductSelectionSummary();
        return ResponseEntity.ok(cheapestProductSelectionSummary);
    }

    @GetMapping("/cheapest-total-brand")
    ResponseEntity<CheapestProductByBrandResponse> fetchCheapestProductBrand() {
        CheapestProductByBrandResponse cheapestProductBrand = catalogService.findCheapestProductBrand();
        return ResponseEntity.ok(cheapestProductBrand);
    }

    @GetMapping("/min-max-prices")
    ResponseEntity<MinMaxPriceByCategoryResponse> fetchCategoryPrices(@RequestParam String categoryName) {
        if (!StringUtils.hasText(categoryName)) {
            throw new BusinessException(ErrorCode.INVALID_INPUT_VALUE, "categoryName parameter cannot be empty or null");
        }
        MinMaxPriceByCategoryResponse minMaxPriceByCategory = catalogService.findMinMaxPriceByCategory(categoryName);
        return ResponseEntity.ok(minMaxPriceByCategory);
    }

}
