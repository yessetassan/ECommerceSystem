package com.yesko.project.product;

import com.yesko.project.dto.product.ProductCreateRequest;
import com.yesko.project.dto.product.ProductPurchaseRequest;
import com.yesko.project.dto.product.ProductPurchaseResponse;
import com.yesko.project.dto.product.ProductResponse;
import com.yesko.project.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(
            @RequestBody @Valid ProductCreateRequest request
    ) {
        return ResponseEntity.ok(service.createOrUpdateProduct(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseProducts(
            @RequestBody @Valid List<ProductPurchaseRequest> request
    ) {
        return ResponseEntity.ok(service.purchaseProducts(request));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<?> findById(
            @PathVariable("product-id") Integer productId
    ) {
        return ResponseEntity.ok(service.findById(productId));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}