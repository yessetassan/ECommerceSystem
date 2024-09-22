package com.yesko.user.dto.address;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddressResponse {
    private Integer id;
    private String street;
    private String houseNumber;
    private String zipCode;
}
