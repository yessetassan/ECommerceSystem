package com.yesko.user.endpoints;

import com.yesko.user.dto.user.PasswordChangeRequest;
import com.yesko.user.dto.user.UserResponse;
import com.yesko.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "User-controller", description = "Пользовательское действие с токеном")
public class UserController {
    private final UserService userService;
    @Operation(summary = "Получить всех пользователей", description = "Эндпоинт для получения всех пользователей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение всех пользователей",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponse.class))),
    })
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @Operation(summary = "Получить текущего пользователя", description = "Эндпоинт для получения информации о текущем пользователе")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение текущего пользователя",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponse.class))),
    })
    @GetMapping("/self")
    public ResponseEntity<UserResponse> getUser() {
        return ResponseEntity.ok().body(userService.selfLoad());
    }

    @Operation(summary = "Получить пользователя по ID", description = "Эндпоинт для получения информации о пользователе по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение пользователя по ID",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponse.class))),
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUsers(
            @PathVariable("id") Integer id
    ) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @Operation(summary = "Изменить пароль пользователя", description = "Эндпоинт для изменения пароля пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пароль успешно изменен",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PasswordChangeRequest.class))),
    })
    @PostMapping("/password")
    public ResponseEntity<?> passwordChange(
            @RequestBody @Validated PasswordChangeRequest request
    ) {
        return ResponseEntity.ok().body(userService.passwordChange(request).getBody());
    }
}