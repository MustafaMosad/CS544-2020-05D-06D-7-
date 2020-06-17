package com.cs544.group7.reservationService.req;

import java.util.List;

public class NewReservationRequest {

	private Integer passengerId;
	private Integer AgentId;
	private String emailAddress;
	private List<Integer> FlightNumbers;
	
	public Integer getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}
	public Integer getAgentId() {
		return AgentId;
	}
	public void setAgentId(Integer agentId) {
		AgentId = agentId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public List<Integer> getFlightNumbers() {
		return FlightNumbers;
	}
	public void setFlightNumbers(List<Integer> flightNumbers) {
		FlightNumbers = flightNumbers;
	}

	

}
