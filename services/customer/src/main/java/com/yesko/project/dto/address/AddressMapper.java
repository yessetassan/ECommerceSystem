package com.yesko.project.dto.address;

import com.yesko.project.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Address toAddress(AddressCreateRequest request) {
        return Address.builder()
                .id(null)
                .street(request.getStreet())
                .houseNumber(request.getHouseNumber())
                .zipCode(request.getZipCode())
                .build();
    }
}
