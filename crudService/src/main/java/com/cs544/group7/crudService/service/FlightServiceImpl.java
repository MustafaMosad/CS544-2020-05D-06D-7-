package com.cs544.group7.crudService.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs544.group7.crudService.domain.Airline;
import com.cs544.group7.crudService.domain.Airport;
import com.cs544.group7.crudService.domain.Flight;
import com.cs544.group7.crudService.repository.AirlineRespository;
import com.cs544.group7.crudService.repository.AirportRepository;
import com.cs544.group7.crudService.repository.FlightRepository;
import com.cs544.group7.crudService.req.RequestFlight;
import com.cs544.group7.crudService.resp.ResponseFlight;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	AirlineRespository airlineRepository;

	@Autowired
	AirportRepository airportRepository;

	@Override
	public void addFlight(RequestFlight requestFlight) {
		Airline airline = airlineRepository.findByCode(requestFlight.getAirlineCode());
		Airport destinationAirport = airportRepository.findByCode(requestFlight.getDestinationAirportCode());
		Airport originAirport = airportRepository.findByCode(requestFlight.getArrivalAirportCode());

		Flight flight = new Flight();
		flight.setDepartureAirport(destinationAirport);
		flight.setArrivalAirport(originAirport);
		flight.setFlight_number(requestFlight.getFlight_number());
		flight.setCapacity(requestFlight.getCapacity());
		flight.setDepartureTime(requestFlight.getDestinationTime());
		flight.setDepartureDate(requestFlight.getDestinationDate());
		flight.setArrivalTime(requestFlight.getArrivalTime());
		flight.setArrivalDate(requestFlight.getArrivalDate());
		flight.setAirline(airline);

		flightRepository.save(flight);
	}

	@Override
	public List<ResponseFlight> getAllFlights() {
//		return flightRepository.findAll().stream()
//				.map(flight->new ResponseFlight(flight.getFlight_number(), flight.getDestinationAirport().getName(),
//						flight.getDestinationTime(), flight.getDestinationDate(), flight.getArrivalAirport().getName(),
//						flight.getArrivalTime(), flight.getArrivalDate(), flight.getAirline().getName()))
//				.collect(Collectors.toList());

		return flightRepository.findAll().stream().parallel().map(this::convertFlightToFlightResponse)
				.collect(Collectors.toList());
	}

	@Override
	public ResponseFlight findFlightById(Integer id) {

		// Temporal
//		return flightRepository.findById(id)
//				.map(flight -> new ResponseFlight(flight.getFlight_number(), flight.getDestinationAirport().getName(),
//						flight.getDestinationTime(), flight.getDestinationDate(), flight.getArrivalAirport().getName(),
//						flight.getArrivalTime(), flight.getArrivalDate(), flight.getAirline().getName()))
//				.get();
		return flightRepository.findById(id).map(this::convertFlightToFlightResponse).get();
	}

	@Override
	public void deleteFlight(Integer id) {
		flightRepository.deleteById(id);
	}

	@Override
	public void updateFlight(Flight flight) {
		flightRepository.save(flight);
	}

	@Override
	public void updateFlight(Integer id, Date departureTime, Date arrivalTime) {

		Flight flight = flightRepository.getOne(id);

		flight.setDepartureTime(departureTime);
		flight.setArrivalTime(arrivalTime);
		updateFlight(flight);
	}

	private ResponseFlight convertFlightToFlightResponse(Flight flight) {
		return new ResponseFlight(flight.getFlight_number(), flight.getDepartureAirport().getName(),
				flight.getDepartureTime(), flight.getDepartureDate(), flight.getArrivalAirport().getName(),
				flight.getArrivalTime(), flight.getArrivalDate(), flight.getAirline().getName());
	}

	@Override
	public List<ResponseFlight> getFlightByDepartureAirportCode(String departureAirPortCode, String arrivalAirPortCode, Date departureDate) {
		return flightRepository.getFlightByDepartureAirportCode(departureAirPortCode, arrivalAirPortCode, departureDate)
				.stream()
				.parallel()
				.map(this::convertFlightToFlightResponse)
				.collect(Collectors.toList());
	}

}
