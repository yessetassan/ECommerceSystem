package com.yesko.user.dto.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Builder
@Data
@Validated
public class JwtRequest {
    @NotEmpty(message = "Username cannot be empty")
    private String username;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
}
