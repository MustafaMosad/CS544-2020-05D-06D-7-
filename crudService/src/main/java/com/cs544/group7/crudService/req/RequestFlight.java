package com.cs544.group7.crudService.req;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "All details about requested flight ")
public class RequestFlight {
	
	private Integer flightNumber;
	
	private Integer capacity;
	 
	private String departureAirportCode;
	
	@Temporal(TemporalType.TIME)
	private Date departureTime;
	
	@Temporal(TemporalType.DATE)
	private Date departureDate;
	 
	private String arrivalAirportCode;
	
	@Temporal(TemporalType.TIME)
	private Date arrivalTime;
	
	@Temporal(TemporalType.DATE)
	private Date arrivalDate;
	
	private String airlineCode;
	
	//parameter less constructor
	public RequestFlight() {}
	
	//parameterized constructor 
	public RequestFlight(Integer flightNumber, Integer capacity, String departureAirportCode, 
							Date departureTime, Date departureDate, String arrivalAirportCode, 
							Date arrivalTime, Date arrivalDate, String airlineCode) 
	{
		super();
		this.flightNumber = flightNumber;
		this.capacity = capacity;
		this.departureAirportCode = departureAirportCode;
		this.departureTime = departureTime;
		this.departureDate = departureDate;
		this.arrivalAirportCode = arrivalAirportCode;
		this.arrivalTime = arrivalTime;
		this.arrivalDate = arrivalDate;
		this.airlineCode = airlineCode;
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

	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
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

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}
	
	
}
