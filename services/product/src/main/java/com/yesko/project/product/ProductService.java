package com.yesko.project.product;

import com.yesko.project.dto.product.*;
import com.yesko.project.exception.ProductPurchaseException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductResponse createProduct(
            ProductCreateRequest request
    ) {
        var product = mapper.toProduct(request);
        product = repository.save(product);
        return mapper.toProductResponse(product);
    }

    public ProductResponse findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID:: " + id));
    }

    public List<ProductResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toProductResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ProductPurchaseResponse> purchaseProducts(
            List<ProductPurchaseRequest> request
    ) {
        var productsId = request
                .stream()
                .map(ProductPurchaseRequest::getProductId)
                .toList();
        var storedProducts = repository.findAllByIdInOrderById(productsId);
        if (productsId.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exist");
        }

        var sortedProducts = request.stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::getProductId)).toList();
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for (int i = 0; i < storedProducts.size() ; i++) {
            var product = storedProducts.get(i);
            var purchaseProduct = sortedProducts.get(i);
            if (product.getAvailableQuantity() < purchaseProduct.getQuantity()) {
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: " + purchaseProduct.getProductId());
            }
            var newAvailableQuantity = product.getAvailableQuantity() - purchaseProduct.getQuantity();
            product.setAvailableQuantity(newAvailableQuantity);
            repository.save(product);
            storedProducts.set(i, product);
            purchasedProducts.add(mapper.toProductPurchaseResponse(product,purchaseProduct));
        }
        /*
        Сохранить всех продуктов после успешней операций
         */
        repository.saveAll(storedProducts);

        log.info("Products are successfully updated");
        return purchasedProducts;
    }

}