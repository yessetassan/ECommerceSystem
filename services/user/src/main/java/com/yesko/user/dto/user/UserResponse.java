package com.yesko.user.dto.user;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
}
