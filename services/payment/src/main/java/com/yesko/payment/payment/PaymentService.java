package com.yesko.payment.payment;

import com.yesko.payment.dto.payment.PaymentMapper;
import com.yesko.payment.dto.payment.PaymentRequest;
import com.yesko.payment.dto.payment.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentMapper mapper;
    private final PaymentRepository repository;
    public PaymentResponse createPayment(PaymentRequest request) {
        return mapper.toPaymentResponse(repository.save(
                Payment.builder()
                        .id(request.getId())
                        .amount(request.getAmount())
                        .paymentMethod(request.getPaymentMethod())
                        .orderId(request.getOrderId())
                        .createdDate(LocalDateTime.now())
                        .build()
        ));
    }
}
