package com.yesko.project.dto.product;

import com.yesko.project.category.Category;
import com.yesko.project.dto.category.CategoryMapper;
import com.yesko.project.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final CategoryMapper categoryMapper;
    public Product toProduct(ProductCreateRequest request) {
        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .availableQuantity(request.getAvailableQuantity())
                .price(request.getPrice())
                .category(Category.builder()
                        .id(request.getCategoryId())
                        .build())
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .availableQuantity(product.getAvailableQuantity())
                .price(product.getPrice())
                .category(categoryMapper.toCategoryResponse(product.getCategory()))
                .build();
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product, ProductPurchaseRequest purchaseProduct) {
        return ProductPurchaseResponse.builder()
                .productId(purchaseProduct.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(purchaseProduct.getQuantity())
                .build();
    }
}
