package com.cs544.group7.userManagementService.security.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("passenger")
public class Passenger extends User {
	@Embedded
	private Address address;

	public Passenger() {
		super();
	}

	public Passenger(String email, String password, String firstName, String lastName, LocalDate birthDate,
			Address address) {
		super(email, password, firstName, lastName, birthDate);
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
