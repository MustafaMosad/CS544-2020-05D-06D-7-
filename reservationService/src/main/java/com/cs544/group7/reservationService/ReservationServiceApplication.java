package com.cs544.group7.reservationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.cs544.group7.reservationService.config.MessagingConfiguration;
import com.cs544.group7.reservationService.domain.Reservation;
import com.cs544.group7.reservationService.sender.MessageSender;

@SpringBootApplication
@EnableEurekaClient
@Configuration
@ComponentScan(basePackages = "com.cs544.group7.reservationService")
@Import({ MessagingConfiguration.class })
public class ReservationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				ReservationServiceApplication.class);
		
		MessageSender messageSender = context.getBean(MessageSender.class);

		Reservation reservation = new Reservation();
		reservation.setConfirmed(true);

		messageSender.sendMessage(reservation);
		System.out.println("Message has been sent successfully to Queue");

		((AbstractApplicationContext) context).close();
	}
	
}
