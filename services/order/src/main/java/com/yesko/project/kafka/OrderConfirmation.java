package com.yesko.project.kafka;

import com.yesko.project.dto.customer.CustomerResponse;
import com.yesko.project.dto.product.PurchaseResponse;
import com.yesko.project.order.PaymentMethod;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class OrderConfirmation {
    String orderReference;
    BigDecimal totalAmount;
    PaymentMethod paymentMethod;
    CustomerResponse customer;
    List<PurchaseResponse> products;
}
