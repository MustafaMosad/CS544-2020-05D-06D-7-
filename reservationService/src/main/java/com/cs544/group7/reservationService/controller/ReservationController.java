package com.cs544.group7.reservationService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs544.group7.reservationService.domain.Ticket;
import com.cs544.group7.reservationService.req.RequestReservation;
import com.cs544.group7.reservationService.res.ResponseFlight;
import com.cs544.group7.reservationService.res.ResponseReservation;
import com.cs544.group7.reservationService.service.ReservationService;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<ResponseReservation> getAllReservations() {
		return reservationService.getAllReservations();
	}

	@PostMapping
	public String addReservation(RequestReservation requestReservation) {
		reservationService.addNewReservation(requestReservation);

		return "redirect:/reservations";
	}

	@GetMapping(value = "/{reservationCode}")
	public ResponseReservation findByReservationCode(@PathVariable String reservationCode) {
		return reservationService.getReservationDetail(reservationCode);
	}

	@GetMapping(value = "/passengerReservations/{passengerId}")
	public List<ResponseReservation> passengerReservations(@PathVariable Long passengerId) {
		return reservationService.getPassengerReservations(passengerId);
	}

	@GetMapping(value = "/agentReservations")
	@PreAuthorize("hasRole('ROLE_AGENT')")
	public List<ResponseReservation> agentReservations() {
		return reservationService.getAgentReservations();
	}

	@DeleteMapping(value = "/{reservationCode}")
	public String cancellReservation(@PathVariable String reservationCode) {
		reservationService.cancelReservation(reservationCode);
		return "redirect:/reservations";
	}

	@PutMapping(value = "/{reservationCode}/confirmReservation")
	public List<Ticket> reservationConfirmation(@PathVariable String reservationCode) {
		return null;
	}

	@GetMapping(value = "/reservedFlight")
	public ResponseFlight getReservedFlight(Integer flightNumber) {
		System.out.println("I am here");
		return reservationService.getFlight(flightNumber);
	}
}
