package com.musinsa.coord.product;

import com.musinsa.coord.common.api.WriteResultResponse;
import com.musinsa.coord.product.dto.ProductRequest;
import com.musinsa.coord.product.dto.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> fetchAllWithVariants(Pageable pageable) {
        Page<ProductResponse> body = productService.findAllWithVariants(pageable);
        return ResponseEntity.ok(body);
    }

    @PostMapping
    public ResponseEntity<WriteResultResponse> create(@RequestBody @Valid ProductRequest request) {
        Long id = productService.createProduct(request);
        WriteResultResponse body = WriteResultResponse.created(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WriteResultResponse> update(@PathVariable Long id, @RequestBody @Valid ProductRequest request) {
        productService.updateProduct(id, request);
        WriteResultResponse body = WriteResultResponse.updated(id);
        return ResponseEntity.ok().body(body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WriteResultResponse> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        WriteResultResponse body = WriteResultResponse.deleted(id);
        return ResponseEntity.ok().body(body);
    }

}
