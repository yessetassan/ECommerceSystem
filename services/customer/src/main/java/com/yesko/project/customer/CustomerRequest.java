package com.yesko.project.customer;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerRequest {
        @NotNull(message = "Id is required")
        String id;
        @NotNull(message = "Customer firstname is required")
        String firstname;
        @NotNull(message = "Customer firstname is required")
        String lastname;
        @NotNull(message = "Customer Email is required")
        @Email(message = "Customer Email is not a valid email address")
        String email;
        Address address;
}