package com.musinsa.coord.catalog.dto;

public record CheapestProductByCategory(
        String category,
        String brand,
        Integer price
) {}
