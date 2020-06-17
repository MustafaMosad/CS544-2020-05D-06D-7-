package com.cs544.group7.reservationService.producer;

import org.springframework.jms.core.JmsTemplate;

import com.cs544.group7.emailService.dto.EmailDto;

public class MessageSenderConfirm {

	public static void confirmAndSend(JmsTemplate jmsTemplate) {
		
		EmailDto emailDto = new EmailDto();
		String emailAddress = emailDto.getTo();
		
		emailAddress = "navinhelpdesk@gmail.com";
		
    System.out.println(">> 1 >> Sent an confirmed email message.");
    jmsTemplate.convertAndSend("message_queue", new EmailDto(emailAddress, "Confirmation", 
    							"Dear Customer, your ticket is confirmed").toString());

	}
}
