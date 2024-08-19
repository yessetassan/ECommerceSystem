package com.yesko.project.dto.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PurchaseRequest implements Serializable {
        @NotNull(message = "Product is mandatory")
        private Integer productId;
        @Positive(message = "Quantity should be > 0")
        @NotNull(message = "Quantity is mandatory")
        private Integer quantity;
}
