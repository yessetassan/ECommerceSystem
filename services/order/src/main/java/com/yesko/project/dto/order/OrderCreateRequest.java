package com.yesko.project.dto.order;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yesko.project.order.PaymentMethod;
import com.yesko.project.dto.product.PurchaseRequest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @NotEmpty(message = "Token should be not empty")
    private String token;
    @Pattern(regexp = "^[a-zA-Z]{9}$", message = "Reference should contain exactly 9 letters")
    @NotEmpty(message = "Reference should be not empty")
    private String reference;
    @NotNull(message = "PaymentMethod should be precised")
    private PaymentMethod paymentMethod;
    @NotEmpty(message = "You should at least purchase one product")
    private List<PurchaseRequest> purchaseRequests;
}
