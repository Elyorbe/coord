package com.musinsa.coord.product.dto;

import java.util.List;

public record ProductResponse(
        Long id,
        Brand brand,
        Category category,
        List<ProductVariant> productVariants,
        String name,
        String code,
        Integer price
) {
    public record ProductVariant(Long id, String color, String size) {}
    public record Brand(Long id, String name) {}
    public record Category(Long id, String name) {}
}
