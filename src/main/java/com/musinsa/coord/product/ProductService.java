package com.musinsa.coord.product;

import com.musinsa.coord.brand.Brand;
import com.musinsa.coord.category.Category;
import com.musinsa.coord.common.error.exception.BusinessException;
import com.musinsa.coord.common.error.exception.ErrorCode;
import com.musinsa.coord.product.dto.ProductRequest;
import com.musinsa.coord.product.dto.ProductResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @PersistenceContext
    private EntityManager entityManager;

    private ProductRepository productRepository;

    public ProductService(EntityManager entityManager, ProductRepository productRepository) {
        this.entityManager = entityManager;
        this.productRepository = productRepository;
    }

    public Page<ProductResponse> findAllWithVariants(Pageable pageable) {
        return productRepository.findAllWithVariants(pageable);
    }

    @Transactional
    public Long createProduct(ProductRequest request) {
        validateRequest(request);
        Brand brand = entityManager.getReference(Brand.class, request.brandId());
        Category category = entityManager.getReference(Category.class, request.categoryId());

        Product product = Product.builder()
                .brand(brand)
                .category(category)
                .name(request.name())
                .code(request.code())
                .price(request.price())
                .build();

        if (request.variants() != null && !request.variants().isEmpty()) {
            request.variants().forEach(variantRequest -> {
                ProductVariant variant = ProductVariant.builder()
                        .product(product)
                        .color(variantRequest.color())
                        .size(variantRequest.size())
                        .build();
                product.addVariant(variant);
            });
        }
        return productRepository.save(product).getId();
    }

    @Transactional
    public void updateProduct(Long id, ProductRequest request) {
        if (productRepository.existsById(id)) {
            throw new BusinessException(ErrorCode.RESOURCE_NOT_FOUND);
        }
        validateRequest(request);
        Product product = entityManager.getReference(Product.class, id);
        product.updateDetails(request.name(), request.code(), request.price());

        if (!product.getBrand().getId().equals(request.brandId()) ||
                !product.getCategory().getId().equals(request.categoryId())) {
            Brand newBrand = entityManager.getReference(Brand.class, request.brandId());
            Category newCategory = entityManager.getReference(Category.class, request.categoryId());
            product.changeBrandAndCategory(newBrand, newCategory);
        }

        entityManager.createQuery("DELETE FROM ProductVariant pv WHERE pv.product.id = :productId")
                .setParameter("productId", product.getId())
                .executeUpdate();
        product.getVariants().clear();


        if (request.variants() != null && !request.variants().isEmpty()) {
            request.variants().forEach(variantRequest -> {
                ProductVariant variant = ProductVariant.builder()
                        .product(product)
                        .color(variantRequest.color())
                        .size(variantRequest.size())
                        .build();
                product.addVariant(variant);
            });
        }
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    private void validateRequest(ProductRequest request) {
        if (productRepository.existsByBrandIdAndCategoryId(request.brandId(), request.categoryId())) {
            throw new BusinessException(ErrorCode.DUPLICATE_PRODUCT);
        }

        boolean brandExists = (Boolean) entityManager
                .createNativeQuery("SELECT EXISTS (SELECT 1 FROM brand WHERE id = :id)")
                .setParameter("id", request.brandId())
                .getSingleResult();

        boolean categoryExists = (Boolean) entityManager
                .createNativeQuery("SELECT EXISTS (SELECT 1 FROM category WHERE id = :id)")
                .setParameter("id", request.categoryId())
                .getSingleResult();

        if (!brandExists || !categoryExists) {
            throw new BusinessException(ErrorCode.REFERENCED_RESOURCE_NOT_EXISTS);
        }
    }

}
