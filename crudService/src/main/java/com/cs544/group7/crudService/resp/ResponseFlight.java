package com.cs544.group7.crudService.resp;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ResponseFlight {
	
	private int flight_number;
	 
	private String destinationAirport;
	
	@Temporal(TemporalType.TIME)
	private Date destinationTime;
	
	@Temporal(TemporalType.DATE)
	private Date destinationDate;
	 
	private String originAirport;
	
	@Temporal(TemporalType.TIME)
	private Date originTime;
	
	@Temporal(TemporalType.DATE)
	private Date originDate;
	
	private String airlineName;

	public ResponseFlight() {}

	public ResponseFlight(int flight_number, String destinationAirport, Date destinationTime,
							Date destinationDate,String originAirport, Date originTime, 
							Date originDate, String airlineName) 
	{
		this.flight_number = flight_number;
		this.destinationAirport = destinationAirport;
		this.destinationTime = destinationTime;
		this.destinationDate = destinationDate;
		this.originAirport = originAirport;
		this.originTime = originTime;
		this.originDate = originDate;
		this.airlineName = airlineName;
	}
	
	// Temporal
	public ResponseFlight(int flight_number, Date destinationTime, Date destinationDate, Date originTime,
			Date originDate) {
		super();
		this.flight_number = flight_number;
		this.destinationTime = destinationTime;
		this.destinationDate = destinationDate;
		this.originTime = originTime;
		this.originDate = originDate;
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

	public String getOriginAirport() {
		return originAirport;
	}

	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}

	public Date getOriginTime() {
		return originTime;
	}

	public void setOriginTime(Date originTime) {
		this.originTime = originTime;
	}

	public Date getOriginDate() {
		return originDate;
	}

	public void setOriginDate(Date originDate) {
		this.originDate = originDate;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	
	
}
