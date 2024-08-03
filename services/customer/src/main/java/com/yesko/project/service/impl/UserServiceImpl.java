package com.yesko.project.service.impl;

import com.yesko.project.dto.user.UserCreateRequest;
import com.yesko.project.dto.user.UserResponse;
import com.yesko.project.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceImpl {
    void createNewUser(UserCreateRequest request);
    UserResponse selfLoad();
    Optional<User> findByUsername(String username);
    UserResponse findById(Integer id);
    Optional<User> findByEmail(String email);
    List<UserResponse> findAll();
}
