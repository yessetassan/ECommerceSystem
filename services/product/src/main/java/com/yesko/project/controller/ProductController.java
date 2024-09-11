package com.yesko.project.controller;

import com.yesko.project.dto.product.ProductCreateRequest;
import com.yesko.project.dto.product.ProductPurchaseRequest;
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
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false,defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(service.findAll(name, page, size));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<?> findById(
            @PathVariable("product-id") Integer productId
    ) {
        return ResponseEntity.ok(service.findById(productId));
    }
    @DeleteMapping("/{product-id}")
    public ResponseEntity<?> deleteById(
            @PathVariable("product-id") Integer productId
    ) {
        service.deleteById(productId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(
            @RequestBody @Valid ProductCreateRequest request
    ) {
        return ResponseEntity.ok(service.createProduct(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseProducts(
            @RequestBody @Valid List<ProductPurchaseRequest> request
    ) {
        return ResponseEntity.ok(service.purchaseProducts(request));
    }
}
