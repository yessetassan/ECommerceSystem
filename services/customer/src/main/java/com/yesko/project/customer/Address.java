package com.yesko.project.customer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Validated
public class Address {
    @NotNull(message = "Street is required")
    @NotEmpty(message = "Street is required")
    private String street;
    @NotNull(message = "ZipCode is required")
    @NotEmpty(message = "ZipCode is required")
    private String zipCode;
    @NotNull(message = "HouseNumber is required")
    @NotEmpty(message = "HouseNumber is required")
    private String houseNumber;
}
