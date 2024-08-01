package com.yesko.payment.dto.customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

public class Customer {
    String id;
    @NotNull(message = "Firstname is required")
    String firstname;
    @NotNull(message = "Lastname is required")
    String lastname;
    @NotNull(message = "Email is required")
    @Email(message = "The customer email is not correctly formatted")
    String email;
}
