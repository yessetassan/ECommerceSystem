package com.yesko.project.product;


import com.yesko.project.dto.product.PurchaseRequest;
import com.yesko.project.dto.product.PurchaseResponse;
import com.yesko.project.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.internal.ParameterizedTypeImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Service
@RequiredArgsConstructor
public class ProductClient {

    @Value("${application.config.product-url}")
    private String productUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    public List<PurchaseResponse> purchaseProducts(List<PurchaseRequest> requests) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE);

        HttpEntity<List<PurchaseRequest>> requestEntity = new HttpEntity<>(requests, httpHeaders);
        ParameterizedTypeReference<List<PurchaseResponse>> responseType = new ParameterizedTypeReference<>() {
        };

        ResponseEntity<List<PurchaseResponse>> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(
                    productUrl + "/purchase",
                    HttpMethod.POST,
                    requestEntity,
                    responseType
            );
        }catch (Exception e) {
            String exceptionMessage = e.getMessage();
            String errorMessage = extractErrorMessage(exceptionMessage);
            throw new BusinessException(errorMessage);
        }

        return responseEntity.getBody();
    }

    public String extractErrorMessage(String exceptionMessage) {
        int startIndex = exceptionMessage.indexOf("\"");
        if (startIndex != -1) {
            return exceptionMessage.substring(startIndex + 1, exceptionMessage.length() - 1);
        }
        return exceptionMessage;
    }
}
