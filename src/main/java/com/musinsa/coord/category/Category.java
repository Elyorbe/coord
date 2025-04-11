package com.musinsa.coord.category;

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
        name = "category",
        uniqueConstraints = @UniqueConstraint(name = "uq_category_name", columnNames = "name")
)
public class Category extends BaseEntity {

    @Column(nullable = false, length = 128, unique = true)
    private String name;

    protected Category() {}

    @Builder
    public Category(String name) {
        this.name = name;
    }

    public void renameTo(String newName) {
        this.name = newName;
    }

}
