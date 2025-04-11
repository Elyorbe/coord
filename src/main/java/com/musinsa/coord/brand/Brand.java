package com.musinsa.coord.brand;

import com.musinsa.coord.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(
        name = "brand",
        uniqueConstraints = @UniqueConstraint(name = "uq_brand_name", columnNames = "name")
)
public class Brand extends BaseEntity {

    @Column(nullable = false, length = 128, unique = true)
    private String name;

    protected Brand() {}

    @Builder
    public Brand(String name) {
        this.name = name;
    }

    public void renameTo(String newName) {
        this.name = newName;
    }

}
