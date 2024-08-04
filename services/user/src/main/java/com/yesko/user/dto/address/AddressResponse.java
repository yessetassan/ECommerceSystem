package com.yesko.user.dto.address;

import com.yesko.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Builder
@Data
public class AddressResponse {
    private Integer id;
    private String street;
    private String houseNumber;
    private String zipCode;
}
