package com.yesko.project.customer;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerResponse {
    String id;
    String firstname;
    String lastname;
    String email;
    Address address;
}