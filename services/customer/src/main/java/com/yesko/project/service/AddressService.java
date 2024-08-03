package com.yesko.project.service;

import com.yesko.project.entity.Address;
import com.yesko.project.repo.AddressRepo;
import com.yesko.project.service.impl.AddressServiceImpl;
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
