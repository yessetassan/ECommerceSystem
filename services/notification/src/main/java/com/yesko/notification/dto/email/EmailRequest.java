package com.yesko.notification.dto.email;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class EmailRequest {
    String destinationEmail;
    String customerName;
    BigDecimal amount;
    String orderReference;
}
