package com.cs544.group7.reservationService.sender;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.cs544.group7.reservationService.domain.Reservation;

@Component
public class MessageSender
{

	@Autowired
	JmsTemplate jmsTemplate;

	public void sendMessage(final Reservation reservation)
	{

		jmsTemplate.send(new MessageCreator()
		{
			public Message createMessage(Session session) throws JMSException
			{
				ObjectMessage objectMessage = session.createObjectMessage((Serializable) reservation);
				return objectMessage;
			}
		});
	}

}
