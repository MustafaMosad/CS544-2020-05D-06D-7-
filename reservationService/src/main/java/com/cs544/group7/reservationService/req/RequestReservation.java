package com.cs544.group7.reservationService.req;

import java.util.Set;

public class RequestReservation {

	private Long passengerId;
	private Long AgentId;
	private Set<Integer> flightNumbers;

	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

	public Long getAgentId() {
		return AgentId;
	}

	public void setAgentId(Long agentId) {
		AgentId = agentId;
	}

	public Set<Integer> getFlightNumbers() {
		return flightNumbers;
	}

	public void setFlightNumbers(Set<Integer> flightNumbers) {
		this.flightNumbers = flightNumbers;
	}

}
