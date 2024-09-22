package com.yesko.user.handler.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ErrorResponseException extends RuntimeException {
    private final String message;
}