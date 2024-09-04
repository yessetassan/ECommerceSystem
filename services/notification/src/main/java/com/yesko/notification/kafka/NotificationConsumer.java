package com.yesko.notification.kafka;


import com.yesko.notification.dto.email.EmailMapper;
//import com.yesko.notification.email.EmailService;
import com.yesko.notification.email.EmailService;
import com.yesko.notification.kafka.order.OrderConfirmation;
import com.yesko.notification.kafka.payment.PaymentConfirmation;
import com.yesko.notification.notification.Notification;
import com.yesko.notification.notification.NotificationRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.yesko.notification.notification.NotificationType.ORDER_CONFIRMATION;
import static com.yesko.notification.notification.NotificationType.PAYMENT_CONFIRMATION;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationRepository repository;
    private final EmailService emailService;

    private final EmailMapper emailMapper;
//    @KafkaListener(topics = "payment-topic")
//    public void consumerPaymentSuccessNotification(PaymentConfirmation confirmation) {
//        log.info(String.format("Consuming the message from payment-topic Topic:: %s", confirmation));
//        repository.save(
//                Notification.builder()
//                        .type(PAYMENT_CONFIRMATION)
//                        .notificationDate(LocalDateTime.now())
//                        .paymentConfirmation(confirmation)
//                        .build()
//        );
//        /*
//        Оправить уведомление по почту насчет покупки
//         */
//        emailService.sendPaymentSuccessEmail(emailMapper.toEmailRequest(confirmation));
//
//    }
    @KafkaListener(topics = "order-topic")
    public void consumerOrderSuccessNotification(OrderConfirmation confirmation)  throws MessagingException {
        log.info(String.format("Consuming the message from payment-topic Topic:: %s", confirmation));
//        repository.save(
//                Notification.builder()
//                        .type(ORDER_CONFIRMATION)
//                        .notificationDate(LocalDateTime.now())
//                        .orderConfirmation(confirmation)
//                        .build()
//        );
//        /*
//        Оправить уведомление по почту насчет заказы
//         */
//        emailService.sendOrderSuccessEmail(emailMapper.toEmailRequest(confirmation));
    }
}
