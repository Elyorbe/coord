package com.musinsa.coord.product.dto;

import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public record ProductRequest(
        @NotNull Long brandId,
        @NotNull Long categoryId,
        String name,
        String code,
        @NotNull Integer price,
        List<ProductVariantRequest> variants
) {
   public ProductRequest {
       if (variants == null) {
           variants = new ArrayList<>();
       }
   }
    public record ProductVariantRequest(String color, String size) {}
}