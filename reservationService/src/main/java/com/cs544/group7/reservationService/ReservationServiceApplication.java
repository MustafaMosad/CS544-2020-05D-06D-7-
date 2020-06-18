package com.cs544.group7.reservationService;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.cs544.group7.reservationService")
public class ReservationServiceApplication {
	static JmsTemplate jmsTemplate;

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(ReservationServiceApplication.class, args);

	}
}
