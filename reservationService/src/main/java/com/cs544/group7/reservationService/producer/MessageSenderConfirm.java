package com.cs544.group7.reservationService.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class MessageSenderConfirm {

 @Autowired
 JmsTemplate jmsTemplate;
 
	public  void sendConfirmation(String Address) {
		
    System.out.println(">> 1 >> Sent an confirmed email message.");
    jmsTemplate.convertAndSend("message_queue", new Email(Address, "Confirmation", 
    							"Dear Customer, your ticket is confirmed").toString());

	}
	
	public  void sendReminder(String Address) {
		
	    System.out.println(">> 1 >> Sent an confirmed email message.");
	    jmsTemplate.convertAndSend("message_queue", new Email(Address, "Reminder", 
	    							"Dear Customer, your flight will start is in 24 hours").toString());

		}
}
