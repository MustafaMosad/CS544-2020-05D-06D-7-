package com.cs544.group7.emailService.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.cs544.group7.emailService.dto.EmailDto;
import com.cs544.group7.emailService.service.EmailService;

@Component
public class EmailReceiver {

    @Autowired
    private EmailService emailService;

    @JmsListener(destination = "message_queue")
    public void receiveMessage(EmailDto emailDto){
        System.out.println("Received " + emailDto);
        emailService.sendMail(emailDto);
    }
}