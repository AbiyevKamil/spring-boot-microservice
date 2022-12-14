package com.kamilabiyev.notificationservice.controller;

import com.kamilabiyev.notificationservice.domain.model.request.MailContent;
import com.kamilabiyev.notificationservice.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    @PostMapping("")
    public void sendMail(@RequestBody MailContent mailContent) {
        mailService.sendMail(mailContent);
    }
}
