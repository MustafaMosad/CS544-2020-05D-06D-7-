package com.cs544.group7.crudService.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(length = 4, nullable = false)
	private int flight_number;

	@Column(nullable = false)
	private int capacity;

	@ManyToOne
	@JoinColumn(name = "destinationAirport_id")
	private Airport destinationAirport;

	@Temporal(TemporalType.TIME)
	private Date destinationTime;

	@Temporal(TemporalType.DATE)
	private Date destinationDate;

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

	public int getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public Date getDestinationTime() {
		return destinationTime;
	}

	public Date getDestinationDate() {
		return destinationDate;
	}

	public void setDestinationDate(Date destinationDate) {
		this.destinationDate = destinationDate;
	}

	public void setDestinationTime(Date destinationTime) {
		this.destinationTime = destinationTime;
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
