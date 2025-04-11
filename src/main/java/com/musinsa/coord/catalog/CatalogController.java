package com.musinsa.coord.catalog;

import com.musinsa.coord.catalog.dto.CheapestProductByBrandResponse;
import com.musinsa.coord.catalog.dto.CheapestProductByCategoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
