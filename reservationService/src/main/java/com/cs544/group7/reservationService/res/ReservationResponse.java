package com.cs544.group7.reservationService.res;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationResponse {

	private String reservationCode;
	private List<ResponseFlight> flights;
	private boolean isConfirmed;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	private String passsengerFirstName;
	private String passengerLastName;

	public List<ResponseFlight> getFlights() {
		return flights;
	}

	public void setFlights(List<ResponseFlight> flights) {
		this.flights = flights;
	}

	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getReservationCode() {
		return reservationCode;
	}

	public void setReservationCode(String reservationCode) {
		this.reservationCode = reservationCode;
	}

	public String getPasssengerFirstName() {
		return passsengerFirstName;
	}

	public void setPasssengerFirstName(String passsengerFirstName) {
		this.passsengerFirstName = passsengerFirstName;
	}

	public String getPassengerLastName() {
		return passengerLastName;
	}

	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}

	
}
