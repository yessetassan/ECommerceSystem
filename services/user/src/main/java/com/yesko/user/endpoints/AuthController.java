package com.yesko.user.endpoints;

import com.yesko.user.dto.user.EmailRequest;
import com.yesko.user.dto.user.JwtRequest;
import com.yesko.user.dto.user.UserCreateRequest;
import com.yesko.user.service.AuthService;
import com.yesko.user.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open-api/users")
@RequiredArgsConstructor
@Tag(name = "Auth-controller", description = "Пользователь можен войти, зарегистрироваться и сменить пароль")
public class AuthController {

    private final AuthService service;
    private final EmailService emailService;
    @Operation(summary = "Создать нового пользователя", description = "Эндпоинт для регистрации нового пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь успешно создан",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserCreateRequest.class))),
    })
    @PostMapping
    public ResponseEntity<?> createNewUser(
            @RequestBody UserCreateRequest request
    ) throws Exception {
        return ResponseEntity.ok().body(service.createNewUser(request).getBody());
    }

    @Operation(summary = "Авторизация пользователя", description = "Эндпоинт для генерации JWT токена при логине пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Токен успешно сгенерирован",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = JwtRequest.class))),
    })
    @PostMapping("/auth")
    public ResponseEntity<?> generateToken(
            @RequestBody JwtRequest request
    ) throws Exception {
        return ResponseEntity.ok().body(service.generateToken(request).getBody());
    }

    @Operation(summary = "Отправить email", description = "Эндпоинт для отправки email пользователю")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Email успешно отправлен",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmailRequest.class))),
    })
    @PostMapping("/email")
    public ResponseEntity<?> sentEmail(
            @RequestBody @Validated EmailRequest request
    ) {
        return ResponseEntity.ok().body(emailService.sentEmail(request).getBody());
    }


}
