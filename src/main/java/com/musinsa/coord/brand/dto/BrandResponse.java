package com.musinsa.coord.brand.dto;

import com.musinsa.coord.brand.Brand;

public record BrandResponse(Long id, String name) {

    public static BrandResponse from(Brand brand) {
        return new BrandResponse(brand.getId(), brand.getName());
    }

}
