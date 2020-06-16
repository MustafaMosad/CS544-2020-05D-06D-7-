package com.cs544.group7.emailService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.cs544.group7.emailService.dto.EmailDto;

	@Component
	public class EmailReceiver {

	    @Autowired
	    private EmailService emailService;

	    @JmsListener(destination = "MailNotificationQueue")
	    public void receiveMessage(EmailDto emailDto){
	        System.out.println("Received " + emailDto);
	        emailService.sendMail(emailDto);
	    }
	}