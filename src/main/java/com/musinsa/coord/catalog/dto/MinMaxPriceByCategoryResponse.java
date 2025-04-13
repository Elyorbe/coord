package com.musinsa.coord.catalog.dto;

import java.util.List;

public record MinMaxPriceByCategoryResponse(
        String categoryName,
        List<ProductPrice> minPrice,
        List<ProductPrice> maxPrice
) {}
