package com.yesko.project.dto.order;

import com.yesko.project.dto.customer.UserResponse;
import com.yesko.project.order.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class OrderMapper {
    public OrderResponse toOrderResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .reference(order.getReference())
                .totalAmount(order.getTotalAmount())
                .paymentMethod(order.getPaymentMethod())
                .userId(order.getUserId())
                .build();
    }

    public Order toOrder(OrderCreateRequest request, UserResponse user, BigDecimal totalAmount) {
        if (request == null) return null;
        return Order.builder()
                .id(null)
                .reference(request.getReference())
                .totalAmount(totalAmount)
                .paymentMethod(request.getPaymentMethod())
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
