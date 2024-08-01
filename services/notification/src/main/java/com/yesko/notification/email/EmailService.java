package com.yesko.notification.email;


import com.yesko.notification.dto.email.EmailRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Async
    public void sendPaymentSuccessEmail(EmailRequest request) {
        String toEmail = "",
                body = String.format("Dear %s %s,\n" +
                                "\n" +
                                "We've received a request to reset the password for your account. To ensure the security of your information, please use the password provided below to access your account and promptly set a new password.\n" +
                                "\n" +
                                "Temporary Password: %s",
                        "","",""),
                subject = String.format("Immediate Action Required: Password Reset for %s, %s",
                        "","");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("yesset.assan@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        javaMailSender.send(message);
    }

    @Async
    public void sendOrderSuccessEmail(EmailRequest request) {
        String toEmail = "",
                body = String.format("Dear %s %s,\n" +
                                "\n" +
                                "We've received a request to reset the password for your account. To ensure the security of your information, please use the password provided below to access your account and promptly set a new password.\n" +
                                "\n" +
                                "Temporary Password: %s",
                        "","",""),
                subject = String.format("Immediate Action Required: Password Reset for %s, %s",
                        "","");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("yesset.assan@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        javaMailSender.send(message);
    }
}
