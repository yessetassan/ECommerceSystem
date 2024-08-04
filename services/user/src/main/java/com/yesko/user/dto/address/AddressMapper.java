package com.yesko.user.dto.address;

import com.yesko.user.entity.Address;
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
