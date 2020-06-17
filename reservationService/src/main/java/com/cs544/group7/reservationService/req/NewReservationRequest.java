package com.cs544.group7.reservationService.req;

import java.util.List;

public class NewReservationRequest {

	private Integer passengerId;
	private Integer AgentId;
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

	public List<Integer> getFlightNumbers() {
		return FlightNumbers;
	}

	public void setFlightNumber(List<Integer> flightNumbers) {
		FlightNumbers = flightNumbers;
	}

}
