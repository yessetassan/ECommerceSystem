package com.yesko.user.service.impl;

import com.yesko.user.entity.Address;

import java.util.Optional;

public interface AddressServiceImpl {
    Optional<Address> findById(Integer id);
    Address save(Address address);
}
