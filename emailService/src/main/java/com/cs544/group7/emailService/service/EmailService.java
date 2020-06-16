package com.cs544.group7.emailService.service;

import org.springframework.mail.MailException;

import com.cs544.group7.emailService.dto.EmailDto;

public interface EmailService {
    void sendMail(EmailDto email) throws MailException;   
}