package com.cs544.group7.reservationService.res;

import java.util.Date;

public class ResponseFlight {

	private int flight_number;

	private String departureAirport;

	private Date destinationTime;

	private Date destinationDate;

	private String arrivalAirport;

	private Date arrivalTime;

	private Date arrivalDate;

	private String airlineName;

	public ResponseFlight() {
	}

	public ResponseFlight(int flight_number, String departureAirport, Date destinationTime, Date destinationDate,
			String arrivalAirport, Date arrivalTime, Date arrivalDate, String airlineName) {
		this.flight_number = flight_number;
		this.departureAirport = departureAirport;
		this.destinationTime = destinationTime;
		this.destinationDate = destinationDate;
		this.arrivalAirport = arrivalAirport;
		this.arrivalTime = arrivalTime;
		this.arrivalDate = arrivalDate;
		this.airlineName = airlineName;
	}

	public int getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
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