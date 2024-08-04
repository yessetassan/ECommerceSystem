package com.yesko.project.service;

import com.yesko.project.dto.address.AddressMapper;
import com.yesko.project.dto.user.UserCreateRequest;
import com.yesko.project.dto.user.UserMapper;
import com.yesko.project.dto.user.UserResponse;
import com.yesko.project.entity.Role;
import com.yesko.project.entity.User;
import com.yesko.project.repo.UserRepo;
import com.yesko.project.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.yesko.project.utils.Constrains.CUSTOMER_ROLE_ID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserServiceImpl, UserDetailsService {
    private final AddressService addressService;

    private final UserRepo repo;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;

    private final PasswordEncoder passwordEncoder;
    @Override
    public void createNewUser(UserCreateRequest request) {
        var user = userMapper.toUser(request);
        var address = addressService.save(addressMapper.toAddress(request.getAddress()));

        user.setAddress(address);
        user.setRole(Role.builder()
                .id(CUSTOMER_ROLE_ID)
                .build());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        repo.save(user);

        log.info("Создался новый ползователь :: {}", userMapper.toUserResponse(user));
    }

    @Override
    public UserResponse selfLoad() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        return userMapper.toUserResponse((User) this.loadUserByUsername(username));
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public UserResponse findById(Integer id) {
        return userMapper.toUserResponse(repo.findById(id).get());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public List<UserResponse> findAll() {
        return repo.findAll()
                .stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repo.findByUsername(username).get();
    }

}
