package com.yesko.payment.notification;

import com.yesko.payment.payment.PaymentMethod;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class PaymentNotificationRequest {
    String orderReference;
    BigDecimal amount;
    PaymentMethod paymentMethod;
    String customerFirstname;
    String customerLastname;
    String customerEmail;
}
