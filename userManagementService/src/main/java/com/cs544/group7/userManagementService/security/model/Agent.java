package com.cs544.group7.userManagementService.security.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("agent")
public class Agent extends User {

	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agent(String email, String password, String firstName, String lastName, LocalDate birthDate) {
		super(email, password, firstName, lastName, birthDate);
	}

}
