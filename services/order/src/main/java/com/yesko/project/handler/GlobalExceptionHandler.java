package com.yesko.project.handler;

import com.yesko.project.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new AppError(exp.getMessage()));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handle(BusinessException exp) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new AppError(exp.getMessage()));
    }
}
