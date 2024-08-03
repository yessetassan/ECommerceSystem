package com.yesko.project.endpoints;

import com.yesko.project.dto.user.JwtRequest;
import com.yesko.project.dto.user.UserCreateRequest;
import com.yesko.project.service.AuthService;
import lombok.RequiredArgsConstructor;
//import org.bouncycastle.jcajce.provider.symmetric.AES;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open-api/users")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;
    @PostMapping
    public ResponseEntity<?> createNewUser(
            @RequestBody UserCreateRequest request
    ) throws Exception {
        return ResponseEntity.ok().body(service.createNewUser(request).getBody());
    }

    @PostMapping("/auth")
    public ResponseEntity<?> generateToken(
            @RequestBody JwtRequest request
    ) throws Exception {
        return ResponseEntity.ok().body(service.generateToken(request).getBody());
    }
}
