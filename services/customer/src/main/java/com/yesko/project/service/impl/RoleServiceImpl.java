package com.yesko.project.service.impl;


import com.yesko.project.entity.Role;

import java.util.Optional;

public interface RoleServiceImpl {
    Optional<Role> findByName(String name);
    Optional<Role> findById(Integer id);
}
