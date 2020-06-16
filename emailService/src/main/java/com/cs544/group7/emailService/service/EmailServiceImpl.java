package com.cs544.group7.emailService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.cs544.group7.emailService.config.EmailConfig;
import com.cs544.group7.emailService.dto.EmailDto;

@Service
public class EmailServiceImpl implements EmailService {


    @Autowired
    private EmailConfig emailConfig;

    @Value("${application.email.server}")
    private String sourceEmailAddress;

    @Override
    public void sendMail(EmailDto email) throws MailException{
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailConfig.getHost());
        mailSender.setPort(emailConfig.getPort());
        mailSender.setUsername(emailConfig.getUsername());
        mailSender.setPassword(emailConfig.getPassword());

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sourceEmailAddress);
        mailMessage.setTo(email.getTo());
        mailMessage.setSubject(email.getSubject());
        mailMessage.setText(email.getMessageBody());

        mailSender.send(mailMessage);
    }
}
