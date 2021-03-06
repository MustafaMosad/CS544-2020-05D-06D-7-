package com.cs544.group7.emailService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs544.group7.emailService.dto.EmailDto;
import com.cs544.group7.emailService.service.EmailService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/email")
@Api(description = "Email controller handles end points related to email operations")
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@PostMapping("/sendemail")
	String sendMail(@RequestBody EmailDto email) {
		emailService.sendMail(email);
		return "Email sent successfully";
	}
}

