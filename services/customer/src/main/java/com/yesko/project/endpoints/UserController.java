package com.yesko.project.endpoints;

import com.yesko.project.dto.user.UserResponse;
import com.yesko.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok().body(userService.findAll());
    }
    @GetMapping("/self")
    public ResponseEntity<UserResponse> getUser() {
        return ResponseEntity.ok().body(userService.selfLoad());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUsers(
            @PathVariable("id") Integer id
    ) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

}

