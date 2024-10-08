package com.yesko.project.orderline;


import com.yesko.project.dto.customer.UserResponse;
import com.yesko.project.dto.product.PurchaseResponse;
import com.yesko.project.order.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(PurchaseResponse response, Order order, UserResponse user) {
        return OrderLine.builder()
                .id(null)
                .order(order)
                .productId(response.getProductId())
                .quantity(response.getQuantity())
                .build();
    }
}
