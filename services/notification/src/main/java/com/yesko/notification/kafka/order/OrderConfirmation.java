package com.yesko.notification.kafka.order;

import com.yesko.notification.kafka.payment.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
public class OrderConfirmation {
    String orderReference;
    BigDecimal totalAmount;
    PaymentMethod paymentMethod;
    Customer customer;
    List<Product> products;
}
