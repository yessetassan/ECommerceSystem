package com.yesko.project.handler;

import com.yesko.project.exception.ProductPurchaseException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductPurchaseException.class)
    public ResponseEntity<?> handle(ProductPurchaseException exp) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new AppError(exp.getMessage()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handle(EntityNotFoundException exp) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new AppError(exp.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new AppError(exp.getMessage()));
    }
}
