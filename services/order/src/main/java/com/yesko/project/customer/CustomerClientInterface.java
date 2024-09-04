package com.yesko.project.customer;


import com.yesko.project.dto.customer.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "customer-service",
        url = "${application.config.customer_url}"
)
public interface CustomerClientInterface {
    @GetMapping("/{customer-id}")
    Optional<UserResponse> findCustomerById(@PathVariable("customer-id") Integer customerId);
}
