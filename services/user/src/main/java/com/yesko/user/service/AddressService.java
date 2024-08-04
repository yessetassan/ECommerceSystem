package com.yesko.user.service;

import com.yesko.user.entity.Address;
import com.yesko.user.repo.AddressRepo;
import com.yesko.user.service.impl.AddressServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressService implements AddressServiceImpl {
    private final AddressRepo repo;
    @Override
    public Optional<Address> findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Address save(Address address) {
        return repo.save(address);
    }
}
