package com.yesko.notification.dto.email;

import com.yesko.notification.kafka.order.Customer;
import com.yesko.notification.kafka.order.OrderConfirmation;
import com.yesko.notification.kafka.payment.PaymentConfirmation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class EmailMapper {

    public EmailRequest toEmailRequest(PaymentConfirmation confirmation) {
        return EmailRequest.builder()
                .destinationEmail(confirmation.getCustomerEmail())
                .customerName(confirmation.getCustomerFirstname() + " " + confirmation.getCustomerLastname())
                .amount(confirmation.getAmount())
                .orderReference(confirmation.getOrderReference())
                .build();
    }

    public EmailRequest toEmailRequest(OrderConfirmation confirmation) {
        Customer customer = confirmation.getCustomer();
        return EmailRequest.builder()
                .destinationEmail(customer.getEmail())
                .customerName(customer.getFirstname() + " " + customer.getLastname())
                .amount(confirmation.getTotalAmount())
                .orderReference(confirmation.getOrderReference())
                .build();
    }
}
