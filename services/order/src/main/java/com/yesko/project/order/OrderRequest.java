package com.yesko.project.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yesko.project.product.PurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.*;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record OrderRequest(
//        String reference,
//        @Positive(message = "Order amount should be positive")
//        BigDecimal totalAmount,
//        @NotNull(message = "PaymentMethod should be precised")
//        PaymentMethod paymentMethod,
        @NotNull(message = "CustomerId should be not null")
        @Positive(message = "CustomerId should be positive")
        Integer customerId
//        @NotEmpty(message = "You should at least purchase one product")
//        List<PurchaseRequest> products
        ) {
}
