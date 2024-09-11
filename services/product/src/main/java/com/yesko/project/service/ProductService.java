package com.yesko.project.service;

import com.yesko.project.dto.product.*;
import org.springframework.data.domain.Page;
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