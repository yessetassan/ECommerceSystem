package com.yesko.project.dto.customer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class CustomerResponse implements Serializable {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
}
