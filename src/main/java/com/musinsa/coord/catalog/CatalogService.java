package com.musinsa.coord.catalog;

import com.musinsa.coord.catalog.dto.CheapestProductByBrand;
import com.musinsa.coord.catalog.dto.CheapestProductByBrandResponse;
import com.musinsa.coord.catalog.dto.CheapestProductByCategory;
import com.musinsa.coord.catalog.dto.CheapestProductByCategoryResponse;
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

}
