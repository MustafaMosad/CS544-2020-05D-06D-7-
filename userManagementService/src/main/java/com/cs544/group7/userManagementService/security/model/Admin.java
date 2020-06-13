package com.cs544.group7.userManagementService.security.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User {

	public Admin() {
		super();
	}

	public Admin(String email, String password, String firstName, String lastName, LocalDate birthDate) {
		super(email, password, firstName, lastName, birthDate);
	}

}
