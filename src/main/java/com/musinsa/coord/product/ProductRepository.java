package com.musinsa.coord.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductReadRepository {

    @Query("""
        SELECT COUNT(p) > 0
        FROM Product p
        WHERE p.brand.id = :brandId AND p.category.id = :categoryId
    """)
    boolean existsByBrandIdAndCategoryId(@Param("brandId") Long brandId, @Param("categoryId") Long categoryId);

}
