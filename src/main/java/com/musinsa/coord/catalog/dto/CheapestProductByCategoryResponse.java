package com.musinsa.coord.catalog.dto;

import java.util.List;

public record CheapestProductByCategoryResponse(
        List<CheapestProductByCategory> selections,
        Integer totalPrice
) {}
