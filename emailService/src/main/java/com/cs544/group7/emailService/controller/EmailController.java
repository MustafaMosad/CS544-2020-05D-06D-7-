package com.cs544.group7.emailService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs544.group7.emailService.dto.EmailDto;
import com.cs544.group7.emailService.service.EmailService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/emails")
@Api(description = "Email controller handles end points related to email operations")
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@GetMapping("/check")
	void sendMail(EmailDto email) {
		
	}
}

