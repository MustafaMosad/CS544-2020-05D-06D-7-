package com.cs544.group7.reservationService.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs544.group7.reservationService.domain.Reservation;
import com.cs544.group7.reservationService.repository.ReservationRepository;
import com.cs544.group7.reservationService.req.RequestReservation;
import com.cs544.group7.reservationService.res.ResponseFlight;
import com.cs544.group7.reservationService.res.ResponseReservation;
import com.cs544.group7.reservationService.util.CrudServiceCaller;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	

	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	CrudServiceCaller crudServiceCaller;
	
	@Override
	public List<ResponseReservation> getAllReservations() {
		
		return reservationRepository.findAll()
				.stream()
				.parallel()
				.map(this::convertReservationToReservationResponse)
				.collect(Collectors.toList());
	}
	
	private ResponseReservation convertReservationToReservationResponse(Reservation reservation) {
		return new ResponseReservation(reservation.getReservationCode(), reservedFlights(reservation.getFlightNumbers()), 
										reservation.isConfirmed(), reservation.getCreatedAt(), 
										getPasssengerFirstName(reservation.getPassengerId()),
										getPasssengerFirstName(reservation.getPassengerId())
									);
	}
	
	private List<ResponseFlight> reservedFlights (Set<Integer> reservedFlightNumbers){
		return new ArrayList<ResponseFlight>();
	}
	
	private String getPasssengerFirstName(Long passengerId) {
		return passengerId.toString();
	}

	@Override
	public void addNewReservation(RequestReservation requestReservation) {
		
		reservationRepository.save(convertRequestReservationToReservation(requestReservation));
		
	}
	
	private Reservation convertRequestReservationToReservation(RequestReservation requestReservation) {
		Reservation reservation = new Reservation();
		reservation.setPassengerId(requestReservation.getPassengerId());
		reservation.setMadeByAgentId(requestReservation.getAgentId());
		reservation.setMadeByUserId(requestReservation.getPassengerId());
		reservation.setFlightNumbers(requestReservation.getFlightNumbers());
		reservation.setCreatedAt(new Date());
		return reservation;
		
		
	}

	@Override
	public ResponseReservation getReservationDetail(String reservationCode) {
		// TODO Auto-generated method stub
		return convertReservationToReservationResponse(reservationRepository.findByReservationCode(reservationCode));
	}

	@Override
	public List<ResponseReservation> getPassengerReservations(Long passengerId) {
		return reservationRepository.findByPassengerId(passengerId)
				.stream()
				.parallel()
				.map(this::convertReservationToReservationResponse)
				.collect(Collectors.toList());
	}

	@Override
	public void cancelReservation(String reservationCode) {
		reservationRepository.delete(reservationRepository.findByReservationCode(reservationCode));
	}
	
	@Override
	public ResponseFlight getFlight(Integer flightNumber) {
		System.out.println("Also I am here");
		return crudServiceCaller.getFlight(flightNumber);
	}
}
