package com.yesko.user.dto.role;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleResponse {
    private Integer id;
    private String name;
}
