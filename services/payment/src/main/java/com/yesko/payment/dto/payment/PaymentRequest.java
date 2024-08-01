package com.yesko.payment.dto.payment;

import com.yesko.payment.dto.customer.Customer;
import com.yesko.payment.payment.PaymentMethod;
import lombok.*;
import org.hibernate.engine.jdbc.batch.spi.BatchBuilder;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PaymentRequest {
    private Integer id;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private Integer orderId;
    private String orderReference;
    private Customer customer;
}
