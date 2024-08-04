package com.yesko.user.service;

import com.yesko.user.entity.Role;
import com.yesko.user.repo.RoleRepo;
import com.yesko.user.service.impl.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService implements RoleServiceImpl {
    private final RoleRepo repo;
    @Override
    public Optional<Role> findByName(String name) {
        return repo.findByName(name);
    }
    @Override
    public Optional<Role> findById(Integer id) {
        return repo.findById(id);
    }
}