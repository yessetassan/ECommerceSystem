package com.yesko.project.service;

import com.yesko.project.dto.product.*;
import com.yesko.project.exception.ProductPurchaseException;
import com.yesko.project.product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import java.util.List;

public interface ProductService {

    ProductResponse createOrUpdateProduct(ProductCreateRequest request);

    ProductResponse findById(Integer id);

    List<ProductResponse> findAll();

    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request);
}