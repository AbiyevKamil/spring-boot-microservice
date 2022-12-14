package com.kamilabiyev.notificationservice.service.impl;

import com.kamilabiyev.notificationservice.domain.model.request.MailContent;
import com.kamilabiyev.notificationservice.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void sendMail(MailContent mailContent) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mailContent.getTo());
        mailMessage.setText(mailContent.getMessage());
        mailMessage.setSubject("Spring boot microservice");
        mailMessage.setFrom(from);
        log.info("Mail send to " + Arrays.toString(mailMessage.getTo()) +
                "\nMessage: " + mailMessage.getText());
//        javaMailSender.send(mailMessage);
    }
}
