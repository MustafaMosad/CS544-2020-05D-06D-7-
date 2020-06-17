package com.cs544.group7.reservationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.cs544.group7.reservationService.producer.MessageSenderConfirm;
import com.cs544.group7.reservationService.producer.MessageSenderSchedule;
import com.cs544.group7.reservationService.res.ReservationResponse;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.cs544.group7.reservationService")
@EnableScheduling
public class ReservationServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ReservationServiceApplication.class, args);
		
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		
		ReservationResponse reservationResponse = new ReservationResponse();
		Boolean check = reservationResponse.isConfirmed();
		
		check=true;
		
		if(check == true) {
		
			MessageSenderConfirm messageSenderConfirm = new MessageSenderConfirm();
		    messageSenderConfirm.confirmAndSend(jmsTemplate);
		}
		
		if(check == true) {
			MessageSenderSchedule messageSenderSchedule = new MessageSenderSchedule();
			messageSenderSchedule.scheduleAndSend(jmsTemplate);
	  }
	}
}
