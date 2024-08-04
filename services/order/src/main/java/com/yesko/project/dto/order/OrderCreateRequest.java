package com.yesko.project.dto.order;

import com.yesko.project.order.PaymentMethod;
import com.yesko.project.dto.product.PurchaseRequest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class OrderCreateRequest implements Serializable {
//    @NotNull(message = "CustomerId should be not null")
//    @Positive(message = "CustomerId should be positive")
//    private Integer customerId;
    @NotEmpty(message = "Token should be not empty")
    private String token;

//    private String reference;
//    @Positive(message = "Order amount should be positive")
//    private BigDecimal totalAmount;
//    @NotNull(message = "PaymentMethod should be precised")
//    private PaymentMethod paymentMethod;
//    @NotEmpty(message = "You should at least purchase one product")
//    private List<PurchaseRequest> purchaseRequests;
}
