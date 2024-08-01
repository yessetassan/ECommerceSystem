package com.yesko.payment.payment;


import com.yesko.payment.dto.payment.PaymentRequest;
import com.yesko.payment.dto.payment.PaymentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping
    public ResponseEntity<PaymentResponse> createPayment(
            @RequestBody @Valid PaymentRequest request
    ){
        return ResponseEntity.ok().body(this.service.createPayment(request));
    }
}
