package com.musinsa.coord.product;

import com.musinsa.coord.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "product_variant")
public class ProductVariant extends BaseEntity {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "fk_product"))
    private Product product;

    @Column(length = 32)
    private String color;

    @Column(length = 32)
    private String size;

    protected ProductVariant() {}

    @Builder
    public ProductVariant(Product product, String color, String size) {
        this.product = product;
        this.color = color;
        this.size = size;
    }

    public void updateOptions(String color, String size) {
        this.color = color;
        this.size = size;
    }

    public void changeProduct(Product product) {
        this.product = product;
    }

}
