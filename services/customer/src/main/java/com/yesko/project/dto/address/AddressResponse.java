package com.yesko.project.dto.address;

import com.yesko.project.entity.User;
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
