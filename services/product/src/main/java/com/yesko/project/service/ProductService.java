package com.yesko.project.service;

import com.yesko.project.dto.product.*;
import com.yesko.project.exception.ProductPurchaseException;
import com.yesko.project.product.Product;
import com.yesko.project.product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import java.util.List;

public interface ProductService {

    ProductResponse findById(Integer id);
    ProductResponse updateById(Integer id,ProductResponse productResponse);
    void deleteById(Integer id);
    ProductResponse createProduct(ProductCreateRequest request);
    Page<ProductResponse> findAll(String name, int page, int size);
    List<ProductResponse> findAll();

    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request);
}