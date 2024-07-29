package com.yesko.project.dto.product;

import com.yesko.project.dto.category.CategoryResponse;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private Integer availableQuantity;
    private BigDecimal price;
    private CategoryResponse category;
}