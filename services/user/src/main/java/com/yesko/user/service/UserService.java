package com.yesko.user.service;

import com.yesko.user.dto.address.AddressMapper;
import com.yesko.user.dto.user.PasswordChangeRequest;
import com.yesko.user.dto.user.UserCreateRequest;
import com.yesko.user.dto.user.UserMapper;
import com.yesko.user.dto.user.UserResponse;
import com.yesko.user.entity.Role;
import com.yesko.user.entity.User;
import com.yesko.user.exceptions.AppError;
import com.yesko.user.handler.Response;
import com.yesko.user.repo.UserRepo;
import com.yesko.user.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.yesko.user.utils.Constrains.CUSTOMER_ROLE_ID;

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
    public void saveExistUser(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        repo.save(user);
        log.info("Пароль обновлялся для ползователья :: {}", userMapper.toUserResponse(user));
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

    public ResponseEntity<?> passwordChange(PasswordChangeRequest request) {
        var user = (User) this.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if(!passwordEncoder.matches(request.getOldPassWord(), user.getPassword())) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),
                    "С старым парольем не совпадает"), HttpStatus.BAD_REQUEST);
        }
        if (!request.getPassword().equals(request.getPasswordAgain())) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),
                    "Новый пароль не совпадает"), HttpStatus.BAD_REQUEST);
        }

        user.setPassword(passwordEncoder.encode(request.getPassword()));
        repo.save(user);
        return ResponseEntity.ok().body(new Response("Пароль успешно изменен..."));
    }
}
