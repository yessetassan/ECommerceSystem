package com.yesko.project.customer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Builder
@Getter
@Setter
@ToString
public class CustomerResponse implements Serializable {
    String id;
    String firstname;
    String lastname;
    String email;
}