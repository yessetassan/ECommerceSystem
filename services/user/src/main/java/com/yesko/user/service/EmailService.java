package com.yesko.user.service;

import com.yesko.user.dto.user.EmailRequest;
import com.yesko.user.exceptions.AppError;
import com.yesko.user.handler.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.apache.commons.text.RandomStringGenerator;

import static com.yesko.user.utils.Constrains.PASSWORD_LENGTH;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final UserService userService;
    @Value("${spring.mail.username}")
    private String from;
    @Async
    public ResponseEntity<?> sentEmail(EmailRequest request) {
        var user = userService.findByEmail(request.getEmail());
        if (user.isEmpty()) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),
                    "Ползователь не найден по данному почту"),HttpStatus.BAD_REQUEST);
        }
        var newPassword = generatePassword();
        String toEmail = request.getEmail(),
                body = String.format("Dear %s %s,\n" +
                                "\n" +
                                "We've received a request to reset the password for your account. To ensure the security of your information, please use the password provided below to access your account and promptly set a new password.\n" +
                                "Temporary Password: %s",
                        user.get().getFirstName(),user.get().getLastName(),newPassword),
                subject = String.valueOf("Password Change...");

        userService.saveExistUser(user.get(), newPassword);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        javaMailSender.send(message);

        return ResponseEntity.ok().body(new Response("Новый пароль отправлено на почту..."));
    }

    public static String generatePassword() {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0', 'z')
                .filteredBy(Character::isLetterOrDigit)
                .build();
        return generator.generate(PASSWORD_LENGTH);
    }
}
