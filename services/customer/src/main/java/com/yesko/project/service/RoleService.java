package com.yesko.project.service;

import com.yesko.project.entity.Role;
import com.yesko.project.repo.RoleRepo;
import com.yesko.project.service.impl.RoleServiceImpl;
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