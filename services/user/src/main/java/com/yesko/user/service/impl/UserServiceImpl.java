package com.yesko.user.service.impl;

import com.yesko.user.dto.user.UserCreateRequest;
import com.yesko.user.dto.user.UserResponse;
import com.yesko.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceImpl {
    void createNewUser(UserCreateRequest request);
    void saveExistUser(User user, String newPassword);
    UserResponse selfLoad();
    Optional<User> findByUsername(String username);
    UserResponse findById(Integer id);
    Optional<User> findByEmail(String email);
    List<UserResponse> findAll();
}
