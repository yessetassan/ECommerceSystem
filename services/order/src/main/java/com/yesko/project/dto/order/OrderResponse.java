package com.yesko.project.dto.order;

import com.yesko.project.dto.product.PurchaseRequest;
import com.yesko.project.order.PaymentMethod;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Builder
@Setter
@Getter
public class OrderResponse implements Serializable {
    private Integer id;
    private String reference;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private Integer userId;
}