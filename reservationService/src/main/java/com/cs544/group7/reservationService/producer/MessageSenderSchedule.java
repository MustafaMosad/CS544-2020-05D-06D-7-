package com.cs544.group7.reservationService.producer;

import org.apache.activemq.ScheduledMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.cs544.group7.emailService.dto.EmailDto;

//@EnableScheduling
public class MessageSenderSchedule {
		
//	@Scheduled(cron="0 30 18 * * *")
	public static void scheduleAndSend(JmsTemplate jmsTemplate) {
		
		EmailDto emailDto = new EmailDto();
		String emailAddress = emailDto.getTo();
		
		emailAddress = "navinhelpdesk@gmail.com";
		
		System.out.println(">> 2 >> Sent an schedule email message.");
	    jmsTemplate.convertAndSend("message_queue", new EmailDto(emailAddress, "Schedule", 
	    		                   "Dear Customer, your flight is tomorrow").toString(),  m -> {
	    		                       m.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 300000);
	    		                       	return m;
	    		                   });
	}
}