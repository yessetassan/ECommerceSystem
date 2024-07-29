package com.yesko.project.dto.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
public class ProductPurchaseRequest implements Serializable {
    @NotNull(message = "Product is mandatory")
    @Positive(message = "ProductId is mandatory")
    Integer productId;
    @Positive(message = "Quantity is mandatory")
    Integer quantity;
}
