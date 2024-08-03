package com.yesko.project.dto.address;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Builder
@Data
@Validated
public class AddressCreateRequest {
    @NotEmpty(message = "Street cannot be empty")
    @Size(max = 100, message = "Street can have a maximum of 100 characters")
    private String street;
    @NotEmpty(message = "House number cannot be empty")
    @Size(max = 10, message = "House number can have a maximum of 10 characters")
    private String houseNumber;
    @NotEmpty(message = "Zip code cannot be empty")
    @Pattern(regexp = "\\d{5}", message = "Zip code must be exactly 5 digits")
    private String zipCode;
}
