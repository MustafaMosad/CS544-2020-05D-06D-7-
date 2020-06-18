package com.cs544.group7.reservationService.res;

import java.util.Date;
import java.util.List;

public class ResponseReservation {

	private String reservationCode;
	private List<ResponseFlight> flights;
	private boolean isConfirmed;
	private boolean isCancelled;
	private Date createdAt;
	private Long passengerId;
	private String passsengerFirstName;
	private String passengerLastName;
	

	public ResponseReservation(String reservationCode, List<ResponseFlight> flights, boolean isConfirmed,
			boolean isCancelled, Date createdAt, Long passengerId, String passsengerFirstName, String passengerLastName) 
	{
		
		this.reservationCode = reservationCode;
		this.flights = flights;
		this.isConfirmed = isConfirmed;
		this.isCancelled = isCancelled;
		this.createdAt = createdAt;
		this.passengerId = passengerId;
		this.passsengerFirstName = passsengerFirstName;
		this.passengerLastName = passengerLastName;
	}

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
	
	
	public boolean isCancelled() {
		return isCancelled;
	}

	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
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
	
	
	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
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
