package com.yesko.notification.kafka.order;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Customer {
    String id;
    String firstname;
    String lastname;
    String email;
}
