package com.cs544.group7.reservationService.res;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ResponseFlight {

	private Integer flightNumber;

	private String departureAirport;
//	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	@JsonFormat(pattern="HH:mm:ss")
	private Date departureTime;

	private Date departureDate;

	private String arrivalAirport;
	
	@JsonFormat(pattern="HH:mm:ss")
	private Date arrivalTime;

	private Date arrivalDate;

	private String airlineName;

	public ResponseFlight() {
	}

	public ResponseFlight(Integer flightNumber, String departureAirport, Date departureTime, Date departureDate,
			String arrivalAirport, Date arrivalTime, Date arrivalDate, String airlineName) {
		this.flightNumber = flightNumber;
		this.departureAirport = departureAirport;
		this.departureTime = departureTime;
		this.departureDate = departureDate;
		this.arrivalAirport = arrivalAirport;
		this.arrivalTime = arrivalTime;
		this.arrivalDate = arrivalDate;
		this.airlineName = airlineName;
	}

	public Integer getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
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
