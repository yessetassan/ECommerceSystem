package com.yesko.project.dto.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductCreateRequest implements Serializable {
        @NotNull(message = "Product name is required")
        private String name;
        @NotNull(message = "Product description is required")
        private String description;
        @Positive(message = "Available quantity should be positive")
        private Integer availableQuantity;
        @Positive(message = "Price should be positive")
        private BigDecimal price;
        @NotNull(message = "Product category is required")
        private Integer categoryId;
}