package com.musinsa.coord.brand;

import com.musinsa.coord.brand.dto.BrandCreateRequest;
import com.musinsa.coord.brand.dto.BrandResponse;
import com.musinsa.coord.brand.dto.BrandUpdateRequest;
import com.musinsa.coord.common.api.WriteResultResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandController {

    private BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> fetchById(@PathVariable Long id) {
        return ResponseEntity.ok(brandService.findBrand(id));
    }

    @GetMapping
    public ResponseEntity<Page<BrandResponse>> list(Pageable pageable) {
        return ResponseEntity.ok(brandService.findAllBrands(pageable));
    }

    @PostMapping
    public ResponseEntity<WriteResultResponse> create(@RequestBody @Valid BrandCreateRequest request) {
        Long id = brandService.createBrand(request);
        WriteResultResponse body = WriteResultResponse.created(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WriteResultResponse> update(@PathVariable Long id, @RequestBody @Valid BrandUpdateRequest request) {
        brandService.updateBrand(id, request);
        WriteResultResponse body = WriteResultResponse.updated(id);
        return ResponseEntity.ok().body(body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WriteResultResponse> delete(@PathVariable Long id) {
        brandService.deleteBrand(id);
        WriteResultResponse body = WriteResultResponse.deleted(id);
        return ResponseEntity.ok().body(body);
    }

}
