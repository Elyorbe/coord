package com.musinsa.coord.product;

import com.musinsa.coord.product.dto.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductReadRepository {

    Page<ProductResponse> findAllWithVariants(Pageable pageable);

}
