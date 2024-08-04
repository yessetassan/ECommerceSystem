package com.yesko.user.service;

import com.yesko.user.dto.address.AddressMapper;
import com.yesko.user.dto.user.*;
import com.yesko.user.entity.Role;
import com.yesko.user.exceptions.AppError;
import com.yesko.user.handler.Response;
import com.yesko.user.repo.AddressRepo;
import com.yesko.user.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.html.HTMLDocument;

import static com.yesko.user.utils.Constrains.CUSTOMER_ROLE_ID;


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
                return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пользователь с указанным именем уже существует..."), HttpStatus.BAD_GATEWAY);
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
            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Неправильный логин или пароль"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }


}
