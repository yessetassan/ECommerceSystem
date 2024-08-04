package com.yesko.user.service.impl;


import com.yesko.user.entity.Role;

import java.util.Optional;

public interface RoleServiceImpl {
    Optional<Role> findByName(String name);
    Optional<Role> findById(Integer id);
}
