package com.yesko.project.endpoints;

import com.yesko.project.dto.user.EmailRequest;
import com.yesko.project.dto.user.JwtRequest;
import com.yesko.project.dto.user.UserCreateRequest;
import com.yesko.project.service.AuthService;
import com.yesko.project.service.EmailService;
import lombok.RequiredArgsConstructor;
//import org.bouncycastle.jcajce.provider.symmetric.AES;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open-api/users")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;
    private final EmailService emailService;
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

    @PostMapping("/email")
    public ResponseEntity<?> sentEmail(
            @RequestBody @Validated EmailRequest request
    ) throws Exception {
        return ResponseEntity.ok().body(emailService.sentEmail(request).getBody());
    }
}
