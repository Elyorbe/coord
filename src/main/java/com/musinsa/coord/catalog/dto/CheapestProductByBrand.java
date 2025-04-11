package com.musinsa.coord.catalog.dto;

import java.util.List;

public record CheapestProductByBrand(
        String brand,
        List<CategoryPrice> categoryPrices,
        Integer totalPrice
) {
    public record CategoryPrice(String category, Integer price) {}
}
