package com.cs544.group7.crudService.resp;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ResponseFlight {

	private Integer id;
	
	private int flight_number;
	 
	private String destinationAirport;
	
	@Temporal(TemporalType.TIME)
	private Date destinationTime;
	
	@Temporal(TemporalType.DATE)
	private Date destinationDate;
	 
	private String arrivalAirport;
	
	@Temporal(TemporalType.TIME)
	private Date arrivalTime;
	
	@Temporal(TemporalType.DATE)
	private Date arrivalDate;
	
	private String airlineName;

	public ResponseFlight() {}

	public ResponseFlight(int id, int flight_number, String destinationAirport, Date destinationTime,
							Date destinationDate,String arrivalAirport, Date arrivalTime, 
							Date arrivalDate, String airlineName) 
	{
		this.id = id;
		this.flight_number = flight_number;
		this.destinationAirport = destinationAirport;
		this.destinationTime = destinationTime;
		this.destinationDate = destinationDate;
		this.arrivalAirport = arrivalAirport;
		this.arrivalTime = arrivalTime;
		this.arrivalDate = arrivalDate;
		this.airlineName = airlineName;
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

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
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

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
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

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	
	
}
