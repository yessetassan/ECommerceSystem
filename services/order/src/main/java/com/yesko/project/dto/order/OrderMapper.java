package com.yesko.project.dto.order;

import com.yesko.project.order.Order;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderMapper {
    public OrderResponse toOrderResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .reference(order.getReference())
                .totalAmount(order.getTotalAmount())
                .paymentMethod(order.getPaymentMethod())
                .customerId(order.getCustomerId())
                .build();
    }

    public Order toOrder(OrderCreateRequest request) {
        if (request == null) return null;
        return null;
//        return Order.builder()
//                .id(null)
//                .reference(request.getReference())
//                .totalAmount(request.getTotalAmount())
//                .paymentMethod(request.getPaymentMethod())
//                .customerId(request.getCustomerId())
//                .createdAt(LocalDateTime.now())
//                .build();
    }
}
