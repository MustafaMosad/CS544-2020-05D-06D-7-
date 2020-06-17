package com.cs544.group7.crudService.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Flight {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(length = 4, nullable = false)
	private Integer flightNumber;

	@Column(nullable = false)
	private Integer capacity;

	@ManyToOne
	@JoinColumn(name = "departureAirport_id")
	private Airport departureAirport;

	@Temporal(TemporalType.TIME)
	private Date departureTime;

	@Temporal(TemporalType.DATE)
	private Date departureDate;

	@ManyToOne
	@JoinColumn(name = "arrivalAirport_id")
	private Airport arrivalAirport;

	@Temporal(TemporalType.TIME)
	private Date arrivalTime;

	@Temporal(TemporalType.DATE)
	private Date arrivalDate;

	@ManyToOne
	@JoinColumn(name = "airlineid")
	private Airline airline;

	// default constructor
	public Flight() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public Date getDepartureDate() {
		return departureDate;

	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;

	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
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

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}
}
