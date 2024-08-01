package com.yesko.project.order;

import com.yesko.project.dto.order.OrderCreateRequest;
import com.yesko.project.dto.order.OrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;
    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(
            @RequestBody @Valid OrderCreateRequest request
    ){
        return ResponseEntity.ok().body(service.createOrder(request));
    }

}
