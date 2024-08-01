package com.yesko.payment.dto.payment;

import com.yesko.payment.payment.Payment;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    public PaymentResponse toPaymentResponse(Payment payment) {
        return PaymentResponse.builder()
                .id(payment.getId())
                .amount(payment.getAmount())
                .paymentMethod(payment.getPaymentMethod())
                .orderId(payment.getOrderId())
                .build();
    }
}
