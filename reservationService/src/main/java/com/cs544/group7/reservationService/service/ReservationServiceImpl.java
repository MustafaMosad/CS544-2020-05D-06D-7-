package com.cs544.group7.reservationService.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs544.group7.reservationService.domain.Reservation;
import com.cs544.group7.reservationService.domain.Ticket;
import com.cs544.group7.reservationService.producer.MessageSenderConfirm;
import com.cs544.group7.reservationService.repository.ReservationRepository;
import com.cs544.group7.reservationService.repository.TicketRepository;
import com.cs544.group7.reservationService.req.RequestReservation;
import com.cs544.group7.reservationService.res.ResponseFlight;
import com.cs544.group7.reservationService.res.ResponseReservation;
import com.cs544.group7.reservationService.res.ResponseTicket;
import com.cs544.group7.reservationService.security.resp.TokenValidationResponse;
import com.cs544.group7.reservationService.security.resp.UserDto;
import com.cs544.group7.reservationService.security.util.AuthenticationServiceCaller;
import com.cs544.group7.reservationService.util.CrudServiceCaller;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ServletContext servletContext;

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	CrudServiceCaller crudServiceCaller;

	@Autowired
	AuthenticationServiceCaller authenticationServiceCaller;

	private UserDto getUserInformation(Long userId) {
		return authenticationServiceCaller.getUserById(userId);
	}

	@Autowired

	static MessageSenderConfirm messageSender;

	@Override
	public List<ResponseReservation> getAllReservations() {

		return reservationRepository.findAll().stream().parallel().map(this::convertReservationToResponseReservation)
				.collect(Collectors.toList());
	}

	private ResponseReservation convertReservationToResponseReservation(Reservation reservation) {
		UserDto passenger = getUserInformation(reservation.getPassengerId());
		return new ResponseReservation(reservation.getReservationCode(),
				reservedFlights(reservation.getFlightNumbers()), reservation.isConfirmed(), reservation.isCancelled(),
				reservation.getCreatedAt(), reservation.getPassengerId(), passenger.getFirstName(),
				passenger.getListName());
	}

	private List<ResponseFlight> reservedFlights(Set<Integer> reservedFlightNumbers) {
		List<ResponseFlight> reservedFlights = new ArrayList<ResponseFlight>();

		Iterator<Integer> value = reservedFlightNumbers.iterator();
		while (value.hasNext()) {
			reservedFlights.add(crudServiceCaller.getFlight(value.next()));
		}
		return reservedFlights;
	}

	@Override
	public void addNewReservation(RequestReservation requestReservation) {
		System.out.println(requestReservation.getPassengerId());
		UserDto passenger = getUserInformation(requestReservation.getPassengerId());
		if (!passenger.isExist()) {
			System.out.println("passenger confirmation failed");
			return;
		}
		System.out.println("passenger confirmation succed");
		reservationRepository.save(convertRequestReservationToReservation(requestReservation));

	}

	// check again============================================
	private Reservation convertRequestReservationToReservation(RequestReservation requestReservation) {
		Reservation reservation = new Reservation();
		reservation.setReservationCode(generateReservationCode());
		reservation.setPassengerId(requestReservation.getPassengerId());
		reservation.setMadeByAgentId(requestReservation.getAgentId());// make use of usermanagement service
		reservation.setMadeByUserId(requestReservation.getPassengerId());
		reservation.setFlightNumbers(requestReservation.getFlightNumbers());
		reservation.setCreatedAt(new Date());
		reservation.setConfirmed(false);
		reservation.setCancelled(false);
		reservation.setLastUpdateDate(new Date());
		return reservation;

	}

	private String generateReservationCode() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString();
	}

	@Override
	public ResponseReservation getReservationDetail(String reservationCode) {
		// TODO Auto-generated method stub
		return convertReservationToResponseReservation(reservationRepository.findByReservationCode(reservationCode));
	}

	@Override
	public List<ResponseReservation> getPassengerReservations(Long passengerId) {
		return reservationRepository.findByPassengerId(passengerId).stream().parallel()
				.map(this::convertReservationToResponseReservation).collect(Collectors.toList());
	}

	@Override
	public List<ResponseReservation> getAgentReservations() {
		TokenValidationResponse userInfo = ((TokenValidationResponse) servletContext.getAttribute("userInfo"));

		Long agentId = userInfo.getId();
		return reservationRepository.findByMadeByAgentId(agentId).stream().parallel()
				.map(this::convertReservationToResponseReservation).collect(Collectors.toList());
	}

	@Override
	public void cancelReservation(String reservationCode) {
		Reservation cancelReservation = reservationRepository.findByReservationCode(reservationCode);
		cancelReservation.setCancelled(true);
		cancelReservation.setConfirmed(false);
		reservationRepository.save(cancelReservation);
	}

	@Override
	public ResponseFlight getFlight(Integer flightNumber) {
		return crudServiceCaller.getFlight(flightNumber);
	}

	@Override
	public List<ResponseTicket> confirmReservation(String reservationCode) {
		Reservation reservation = reservationRepository.findByReservationCode(reservationCode);
		List<Ticket> tickets = new ArrayList<Ticket>();
		List<ResponseTicket> responseTickets = new ArrayList<ResponseTicket>();
		if (reservation != null) {
			reservation.setConfirmed(true);
			for (Integer flightNumber : reservation.getFlightNumbers()) {
				ResponseFlight responseFlight = crudServiceCaller.getFlight(flightNumber);

				Ticket ticket = new Ticket(flightNumber, responseFlight.getAirlineName(),
						responseFlight.getDepartureAirport(), responseFlight.getArrivalAirport(),
						responseFlight.getDepartureTime(), responseFlight.getDepartureDate(),
						responseFlight.getArrivalTime(), responseFlight.getArrivalDate(), reservation);
				ticketRepository.save(ticket);
				responseTickets.add(convertTichetToResponseTicket(ticket));
				tickets.add(ticket);
			}
			TokenValidationResponse userInfo = (TokenValidationResponse) servletContext.getAttribute("userInfo");
			sendConfirmationMail(userInfo.getUsername());
			scheduleReminderMail(userInfo.getUsername(), tickets.get(0).getDepartureDate());
			reservationRepository.save(reservation);
		}
		return responseTickets;
	}

	private ResponseTicket convertTichetToResponseTicket(Ticket ticket) {
		return new ResponseTicket(ticket.getFlightNumber(), ticket.getAirlineName(), ticket.getDepratureAirport(),
				ticket.getArrivalAirport(), ticket.getDepartureTime(), ticket.getDepartureDate(),
				ticket.getArrivalTime(), ticket.getArrivalDate(), ticket.getIssuedAt(),
				ticket.getReservation().getReservationCode());
	}

	private void scheduleReminderMail(String emailAddress, Date departureDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(departureDate);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		Date oneDayBefore = cal.getTime();
		Timer timer = new Timer();
		MyTimeTask timerTask = new MyTimeTask();
		timerTask.setAddress(emailAddress);
		// Use this if you want to execute it once
		timer.schedule(timerTask, oneDayBefore);

	}

	private void sendConfirmationMail(String emailAddress) {
		messageSender.sendConfirmation(emailAddress);

	}

	private static class MyTimeTask extends TimerTask {
		private String address;

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public void run() {
			messageSender.sendReminder(address);
		}
	}
}
