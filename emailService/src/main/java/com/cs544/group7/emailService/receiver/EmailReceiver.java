package com.cs544.group7.emailService.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cs544.group7.emailService.dto.EmailDto;
import com.cs544.group7.emailService.service.EmailService;
import com.google.gson.Gson;

@Component
public class EmailReceiver {

    @Autowired
    private EmailService emailService;

    @JmsListener(destination = "message_queue")
    public void receiveMessage(String emailDtoJSON){
    	System.out.println(emailDtoJSON);
    	Gson gson = new Gson();
    	EmailDto emailDto = gson.fromJson(emailDtoJSON, EmailDto.class);
    	System.out.println(emailDto.getMessageBody());
    	System.out.println(emailDto.getTo());
    	System.out.println(emailDto.getSubject());
        emailService.sendMail(emailDto);
    }
}