package com.cs544.group7.crudService.req;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "All details about requested flight ")
public class RequestFlight {
	
	private int flight_number;
	
	private int capacity;
	 
	private String destinationAirportCode;
	
	@Temporal(TemporalType.TIME)
	private Date destinationTime;
	
	@Temporal(TemporalType.DATE)
	private Date destinationDate;
	 
	private String arrivalAirportCode;
	
	@Temporal(TemporalType.TIME)
	private Date arrivalTime;
	
	@Temporal(TemporalType.DATE)
	private Date arrivalDate;
	
	private String airlineCode;
	
	//parameter less constructor
	public RequestFlight() {}
	
	//parameterized constructor 
	public RequestFlight(int flight_number, int capacity, String destinationAirportCode, 
							Date destinationTime, Date destinationDate, String arrivalAirportCode, 
							Date arrivalTime, Date arrivalDate, String airlineCode) 
	{
		super();
		this.flight_number = flight_number;
		this.capacity = capacity;
		this.destinationAirportCode = destinationAirportCode;
		this.destinationTime = destinationTime;
		this.destinationDate = destinationDate;
		this.arrivalAirportCode = arrivalAirportCode;
		this.arrivalTime = arrivalTime;
		this.arrivalDate = arrivalDate;
		this.airlineCode = airlineCode;
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

	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}

	public void setDestinationAirportCode(String destinationAirportCode) {
		this.destinationAirportCode = destinationAirportCode;
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
