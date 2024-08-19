package com.yesko.user.endpoints;

import com.yesko.user.dto.user.EmailRequest;
import com.yesko.user.dto.user.JwtRequest;
import com.yesko.user.dto.user.PasswordChangeRequest;
import com.yesko.user.dto.user.UserCreateRequest;
import com.yesko.user.service.AuthService;
//import com.yesko.user.service.EmailService;
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
//    private final EmailService emailService;
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

//    @PostMapping("/email")
//    public ResponseEntity<?> sentEmail(
//            @RequestBody @Validated EmailRequest request
//    ) {
//        return ResponseEntity.ok().body(emailService.sentEmail(request).getBody());
//    }

}
