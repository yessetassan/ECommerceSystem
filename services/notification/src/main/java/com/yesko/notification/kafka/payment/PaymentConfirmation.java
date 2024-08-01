package com.yesko.notification.kafka.payment;

import lombok.*;

import java.math.BigDecimal;
@Builder
@Getter
@Setter
@ToString
public class PaymentConfirmation {
    String orderReference;
    BigDecimal amount;
    PaymentMethod paymentMethod;
    String customerFirstname;
    String customerLastname;
    String customerEmail;
}
