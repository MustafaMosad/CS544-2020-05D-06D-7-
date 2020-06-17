package com.cs544.group7.reservationService.service;

import java.util.List;

import com.cs544.group7.reservationService.req.RequestReservation;
import com.cs544.group7.reservationService.res.ResponseFlight;
import com.cs544.group7.reservationService.res.ResponseReservation;

public interface ReservationService {

	public List<ResponseReservation> getAllReservations();
	
	public void addNewReservation(RequestReservation requestReservation);
	
	public ResponseReservation getReservationDetail(String reservationCode);
	
	public List<ResponseReservation> getPassengerReservations(Long passengerId);
	
	public void cancelReservation(String reservationCode);
	
	public ResponseFlight getFlight(Integer flightNumber);

	List<ResponseReservation> getAgentReservations();
}
