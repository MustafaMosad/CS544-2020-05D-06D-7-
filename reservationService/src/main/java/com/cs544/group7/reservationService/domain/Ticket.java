package com.cs544.group7.reservationService.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ticket {

	@Id
	@GeneratedValue
	private Long id;
	private Integer flightNumber;
	private String airlineName;
	private String depratureAirport;
	private String arrivalAirport;
	private String passsengerFirstName;
	private String passengerLastName;
	private Integer seatNumber;
	private Date destinationTime;
	private Date destinationDate;
	private Date arrivalTime;
	private Date arrivalDate;

	private Date issuedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getDepratureAirport() {
		return depratureAirport;
	}

	public void setDepratureAirport(String depratureAirport) {
		this.depratureAirport = depratureAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
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

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Date getDestinationTime() {
		return destinationTime;
	}

	public void setDestinationTime(Date destinationTime) {
		this.destinationTime = destinationTime;
	}

	public Date getDestinationDate() {
		return destinationDate;
	}

	public void setDestinationDate(Date destinationDate) {
		this.destinationDate = destinationDate;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(Date issuedAt) {
		this.issuedAt = issuedAt;
	}

}
