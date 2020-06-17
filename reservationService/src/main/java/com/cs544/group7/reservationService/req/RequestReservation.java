package com.cs544.group7.reservationService.req;


import java.util.Set;

public class RequestReservation {

	private Long passengerId;
	private Integer AgentId;
	private Set<Integer> FlightNumbers;

	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

	public Integer getAgentId() {
		return AgentId;
	}

	public void setAgentId(Integer agentId) {
		AgentId = agentId;
	}

	public Set<Integer> getFlightNumbers() {
		return FlightNumbers;
	}

	public void setFlightNumber(Set<Integer> flightNumbers) {
		FlightNumbers = flightNumbers;
	}

}
