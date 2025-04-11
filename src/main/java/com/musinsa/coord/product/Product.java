package com.musinsa.coord.product;

import com.musinsa.coord.brand.Brand;
import com.musinsa.coord.category.Category;
import com.musinsa.coord.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(
        name = "product",
        uniqueConstraints = @UniqueConstraint(name = "uq_brand_category", columnNames = {"brand_id", "category_id"})
)
public class Product extends BaseEntity {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false, foreignKey = @ForeignKey(name = "fk_brand"))
    private Brand brand;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false, foreignKey = @ForeignKey(name = "fk_category"))
    private Category category;

    @Column(length = 128)
    private String name;

    @Column(length = 128)
    private String code;

    @Column(nullable = false)
    private Integer price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductVariant> variants = new ArrayList<>();

    public void addVariant(ProductVariant variant) {
        variants.add(variant);
    }

    public void removeVariant(ProductVariant variant) {
        variants.remove(variant);
    }

    protected Product() {}

    @Builder
    public Product(Brand brand, Category category, String name, String code, Integer price) {
        this.brand = brand;
        this.category = category;
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public void updateDetails(String name, String code, Integer price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public void changeBrandAndCategory(Brand newBrand, Category newCategory) {
        this.brand = newBrand;
        this.category = newCategory;
    }

}
