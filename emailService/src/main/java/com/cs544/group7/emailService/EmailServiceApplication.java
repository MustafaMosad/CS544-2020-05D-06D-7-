package com.cs544.group7.emailService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.cs544.group7.emailService.config.MessagingConfiguration;
import com.cs544.group7.emailService.config.MessagingListnerConfiguration;


@SpringBootApplication
@EnableEurekaClient
@Configuration
@ComponentScan(basePackages = "com.cs544.group7.emailService")
@Import({ MessagingConfiguration.class, MessagingListnerConfiguration.class })
public class EmailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}
}
