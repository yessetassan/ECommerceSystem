package com.yesko.project.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(
        @NotNull(message = "Product is mandatory")
        Integer productId,
        @Positive(message = "Quantity should be > 0")
        @NotNull(message = "Quantity is mandatory")
        Integer quantity
) {
}
