package com.musinsa.coord.brand;

import com.musinsa.coord.brand.dto.BrandCreateRequest;
import com.musinsa.coord.brand.dto.BrandResponse;
import com.musinsa.coord.brand.dto.BrandUpdateRequest;
import com.musinsa.coord.common.error.exception.BusinessException;
import com.musinsa.coord.common.error.exception.ErrorCode;
import com.musinsa.coord.product.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrandService {

    private BrandRepository brandRepository;
    private ProductRepository productRepository;

    public BrandService(BrandRepository brandRepository, ProductRepository productRepository) {
        this.brandRepository = brandRepository;
        this.productRepository = productRepository;
    }

    public BrandResponse findBrand(Long id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.RESOURCE_NOT_FOUND));

        return BrandResponse.from(brand);
    }

    public Page<BrandResponse> findAllBrands(Pageable pageable) {
        return brandRepository.findAll(pageable)
                .map(BrandResponse::from);
    }

    @Transactional
    public Long createBrand(BrandCreateRequest request) {
        if (brandRepository.existsByName(request.name())) {
            throw new BusinessException(ErrorCode.DUPLICATE_RESOURCE);
        }

        Brand brand = Brand.builder()
                .name(request.name())
                .build();

        return brandRepository.save(brand).getId();
    }

    @Transactional
    public void updateBrand(Long id, BrandUpdateRequest request) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.RESOURCE_NOT_FOUND));

        if (!brand.getName().equals(request.name()) && brandRepository.existsByName(request.name())) {
            throw new BusinessException(ErrorCode.DUPLICATE_RESOURCE);
        }

        brand.renameTo(request.name());
    }

    @Transactional
    public void deleteBrand(Long id) {
        if (!brandRepository.existsById(id)) {
            throw new BusinessException(ErrorCode.RESOURCE_NOT_FOUND);
        }
        boolean hasAssociatedProducts = productRepository.existsByBrandId(id);
        if (hasAssociatedProducts) {
            throw new BusinessException(ErrorCode.BRAND_HAS_ASSOCIATED_PRODUCTS);
        }
        brandRepository.deleteById(id);
    }

}
