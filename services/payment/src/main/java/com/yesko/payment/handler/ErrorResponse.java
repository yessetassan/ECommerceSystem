package com.yesko.payment.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}