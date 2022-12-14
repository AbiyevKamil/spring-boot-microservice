package com.kamilabiyev.notificationservice.service;

import com.kamilabiyev.notificationservice.domain.model.request.MailContent;

public interface MailService {
    public void sendMail(MailContent mailContent);
}
