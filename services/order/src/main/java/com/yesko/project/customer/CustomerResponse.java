package com.yesko.project.customer;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email
) {

}