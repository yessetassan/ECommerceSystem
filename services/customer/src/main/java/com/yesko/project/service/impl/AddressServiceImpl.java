package com.yesko.project.service.impl;

import com.yesko.project.entity.Address;

import java.awt.font.OpenType;
import java.util.Optional;

public interface AddressServiceImpl {
    Optional<Address> findById(Integer id);
    Address save(Address address);
}
