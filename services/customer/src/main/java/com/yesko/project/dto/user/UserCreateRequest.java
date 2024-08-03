package com.yesko.project.dto.user;

import com.yesko.project.dto.address.AddressCreateRequest;
import jakarta.validation.*;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Builder
@Data
@Validated
public class UserCreateRequest {
    @NotEmpty(message = "Username cannot be empty")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotEmpty(message = "First name cannot be empty")
    @Size(max = 50, message = "First name can have a maximum of 50 characters")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    @Size(max = 50, message = "Last name can have a maximum of 50 characters")
    private String lastName;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @Valid
    private AddressCreateRequest address;
}
