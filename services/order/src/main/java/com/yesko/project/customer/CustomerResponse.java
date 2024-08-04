package com.yesko.project.customer;

import lombok.*;

import java.io.Serializable;

@Builder
@Data
public class CustomerResponse {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
}