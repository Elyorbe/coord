package com.musinsa.coord.brand.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BrandCreateRequest(
        @NotBlank(message = "Brand name must not be blank")
        @Size(max = 128, message = "Brand name must not exceed 128 characters")
        String name
) {}
