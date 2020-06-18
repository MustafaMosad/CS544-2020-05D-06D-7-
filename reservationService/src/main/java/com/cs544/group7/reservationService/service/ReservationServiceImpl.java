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
import com.cs544.group7.reservationService.security.resp.TokenValidationResponse;
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
	static MessageSenderConfirm messageSender;
	 
	@Override
	public List<ResponseReservation> getAllReservations() {

		return reservationRepository.findAll().stream().parallel().map(this::convertReservationToReservationResponse)
				.collect(Collectors.toList());
	}

	private ResponseReservation convertReservationToReservationResponse(Reservation reservation) {
		return new ResponseReservation(reservation.getReservationCode(),
				reservedFlights(reservation.getFlightNumbers()), reservation.isConfirmed(), reservation.getCreatedAt(),
				getPasssengerFirstName(reservation.getPassengerId()),
				getPasssengerFirstName(reservation.getPassengerId()));
	}

	private List<ResponseFlight> reservedFlights(Set<Integer> reservedFlightNumbers) {
		List<ResponseFlight> reservedFlights = new ArrayList<ResponseFlight>();
//		Integer[] convertSetTolist = (Integer[]) reservedFlightNumbers.toArray();
		System.out.println("from here");

		Iterator<Integer> value = reservedFlightNumbers.iterator();
		while (value.hasNext()) {
			reservedFlights.add(crudServiceCaller.getFlight(value.next()));
		}
//		reservedFlightNumbers.iterator(){
//			
//		}
//		for(int i=0; i< convertSetTolist.length;i++) {
//			System.out.println("I have been here to get flights");
//			return reservedFlights;
		return reservedFlights;
	}

//	private List<ResponseFlight> reservedFlights(Set<Integer> reservedFlightNumbers) {
//		return new ArrayList<ResponseFlight>();
//	}

	private String getPasssengerFirstName(Long passengerId) {
		return passengerId.toString();
	}

	@Override
	public void addNewReservation(RequestReservation requestReservation) {
		System.out.println("From here i am printing");

		reservationRepository.save(convertRequestReservationToReservation(requestReservation));

	}

	private Reservation convertRequestReservationToReservation(RequestReservation requestReservation) {
		Reservation reservation = new Reservation();
		reservation.setReservationCode(generateReservationCode());
		reservation.setPassengerId(requestReservation.getPassengerId());
		reservation.setMadeByAgentId(requestReservation.getAgentId());
		reservation.setMadeByUserId(requestReservation.getPassengerId());
		System.out.println(requestReservation.getPassengerId());
		reservation.setFlightNumbers(requestReservation.getFlightNumbers());
		reservation.setCreatedAt(new Date());
		System.out.println("From here i am printing too");
		return reservation;

	}

	private String generateReservationCode() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString();
	}

	@Override
	public ResponseReservation getReservationDetail(String reservationCode) {
		// TODO Auto-generated method stub
		return convertReservationToReservationResponse(reservationRepository.findByReservationCode(reservationCode));
	}

	@Override
	public List<ResponseReservation> getPassengerReservations(Long passengerId) {
		return reservationRepository.findByPassengerId(passengerId).stream().parallel()
				.map(this::convertReservationToReservationResponse).collect(Collectors.toList());
	}

	@Override
	public List<ResponseReservation> getAgentReservations() {
		TokenValidationResponse userInfo = ((TokenValidationResponse) servletContext.getAttribute("userInfo"));

		Long agentId = userInfo.getId();
		return reservationRepository.findByMadeByAgentId(agentId).stream().parallel()
				.map(this::convertReservationToReservationResponse).collect(Collectors.toList());
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

	@Override
	public List<Ticket> confirmReservation(String reservationCode) {
		Reservation reservation = reservationRepository.findByReservationCode(reservationCode);
		List<Ticket> tickets = new ArrayList<Ticket>();
		if (reservation != null) {
			reservation.setConfirmed(true);
			for (Integer flightNumber : reservation.getFlightNumbers()) {
				ResponseFlight responseFlight = crudServiceCaller.getFlight(flightNumber);
				Ticket ticket = new Ticket(flightNumber, responseFlight.getAirlineName(),
						responseFlight.getDepartureAirport(), responseFlight.getArrivalAirport(),
						responseFlight.getDepartureTime(), responseFlight.getDepartureDate(),
						responseFlight.getArrivalTime(), responseFlight.getArrivalDate());
				ticketRepository.save(ticket);
				tickets.add(ticket);
			}
          TokenValidationResponse userInfo = (TokenValidationResponse)servletContext.getAttribute("userInfo");
			sendConfirmationMail(userInfo.getUsername());
			scheduleReminderMail(userInfo.getUsername() ,tickets.get(0).getDepartureDate());
			reservationRepository.save(reservation);
		}
		return tickets;
	}

	private void scheduleReminderMail(String emailAddress , Date departureDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(departureDate);
		cal.add(Calendar.DAY_OF_YEAR,-1);
		Date oneDayBefore= cal.getTime();
		  Timer timer = new Timer();
		  MyTimeTask timerTask = new MyTimeTask();
		  timerTask.setAddress(emailAddress);
		    //Use this if you want to execute it once
		    timer.schedule(timerTask, oneDayBefore);
		
	}

	private void sendConfirmationMail(String emailAddress) {
		messageSender.sendConfirmation(emailAddress);

	}
	
	private static class MyTimeTask extends TimerTask
	{
		private String address;
		
		
	    public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public void run()
	    {   
		    messageSender.sendReminder(address);
	    }
	}
}
