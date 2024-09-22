package com.yesko.user.service;

import com.yesko.user.dto.address.AddressMapper;
import com.yesko.user.dto.user.JwtRequest;
import com.yesko.user.dto.user.JwtResponse;
import com.yesko.user.dto.user.UserCreateRequest;
import com.yesko.user.dto.user.UserMapper;
import com.yesko.user.handler.Response;
import com.yesko.user.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UserService userService;
    private final AddressService addressService;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;

    private final UserMapper userMapper;
    private final AddressMapper addressMapper;
    @Transactional
    public ResponseEntity<?> createNewUser(UserCreateRequest request) throws Exception {
        try {
            if (userService.findByUsername(request.getUsername()).isPresent()) {
                return ResponseEntity.badRequest().body(new Response("Пользователь с указанным именем уже существует..."));
            }
            userService.createNewUser(request);
            return ResponseEntity.ok().body(new Response("Успешно создался новый пользователь..."));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(new Response("Пройзошла какая то ошибка..."));
        }
    }

    @Transactional
    public ResponseEntity<?> generateToken(JwtRequest request) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body(new Response("Неправильный логин или пароль"));
        }
        UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }


}
