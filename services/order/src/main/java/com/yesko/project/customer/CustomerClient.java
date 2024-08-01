package com.yesko.project.customer;

import com.yesko.project.dto.product.PurchaseRequest;
import com.yesko.project.dto.product.PurchaseResponse;
import com.yesko.project.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


import com.yesko.project.dto.product.PurchaseRequest;
import com.yesko.project.dto.product.PurchaseResponse;
import com.yesko.project.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.internal.ParameterizedTypeImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerClient {

    @Value("${application.config.customer-url}")
    private String customerUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    @Transactional
    public CustomerResponse findCustomerById(Integer customerId) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE);

            HttpEntity<List<PurchaseRequest>> requestEntity = new HttpEntity<>(null, httpHeaders);
            ParameterizedTypeReference<CustomerResponse> responseType = new ParameterizedTypeReference<>() {
            };
            ResponseEntity<CustomerResponse> responseEntity = restTemplate.exchange(
                    customerUrl + "/" + customerId,
                    HttpMethod.GET,
                    requestEntity,
                    responseType
            );
            log.info("Good...");
            return responseEntity.getBody();
        }catch (Exception e) {
            throw new BusinessException("An error occurred while getting customer with ID:: " + customerId);
        }
    }
}
