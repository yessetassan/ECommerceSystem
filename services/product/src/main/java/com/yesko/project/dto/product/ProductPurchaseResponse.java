package com.yesko.project.dto.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class ProductPurchaseResponse  implements Serializable {
    private Integer productId;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
