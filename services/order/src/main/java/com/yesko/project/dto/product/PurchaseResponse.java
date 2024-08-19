package com.yesko.project.dto.product;


import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class PurchaseResponse implements Serializable{
    private Integer productId;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
