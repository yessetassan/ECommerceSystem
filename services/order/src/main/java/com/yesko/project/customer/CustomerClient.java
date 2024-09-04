package com.yesko.project.customer;

import com.yesko.project.dto.customer.UserResponse;
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

import static org.springframework.http.HttpHeaders.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerClient {

    @Value("${application.config.customer-url}")
    private String userUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    @Transactional
    public UserResponse findCustomerByToken(String token) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set(CONTENT_TYPE, APPLICATION_JSON_VALUE);
            httpHeaders.setBearerAuth(token);

            HttpEntity<?> requestEntity = new HttpEntity<>(null, httpHeaders);
            ParameterizedTypeReference<UserResponse> responseType = new ParameterizedTypeReference<>() {
            };
            ResponseEntity<UserResponse> responseEntity = restTemplate.exchange(
                    userUrl + "/self",
                    HttpMethod.GET,
                    requestEntity,
                    responseType
            );
            return responseEntity.getBody();
        }catch (Exception e) {
            throw new BusinessException("Пройзошла ошибка с токеном: " + token);
        }
    }
}
