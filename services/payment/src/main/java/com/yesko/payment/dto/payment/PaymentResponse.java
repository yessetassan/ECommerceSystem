package com.yesko.payment.dto.payment;


import com.yesko.payment.dto.customer.Customer;
import com.yesko.payment.payment.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PaymentResponse {
    Integer id;
    BigDecimal amount;
    PaymentMethod paymentMethod;
    Integer orderId;
    String orderReference;
    Customer customer;
}
