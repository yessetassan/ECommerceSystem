package com.yesko.project.dto.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class PurchaseRequest implements Serializable {
        @NotNull(message = "Product is mandatory")
        private Integer productId;
        @Positive(message = "Quantity should be > 0")
        @NotNull(message = "Quantity is mandatory")
        private Integer quantity;
}
