package com.yesko.notification.kafka.order;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class Product {
    Integer productId;
    String name;
    String description;
    BigDecimal price;
    Integer quantity;
}
