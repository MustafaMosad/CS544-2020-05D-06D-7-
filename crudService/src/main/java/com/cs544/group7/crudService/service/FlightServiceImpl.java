package com.cs544.group7.crudService.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs544.group7.crudService.domain.Flight;
import com.cs544.group7.crudService.repository.FlightRepository;
import com.cs544.group7.crudService.req.RequestFlight;
import com.cs544.group7.crudService.resp.ResponseFlight;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Override
	public void addFlight(RequestFlight requestFlight) {
		
		Flight flight = new Flight();
		flight.setFlight_number(requestFlight.getFlight_number());
		flight.setCapacity(requestFlight.getCapacity());
		flight.setDestinationTime(requestFlight.getDestinationTime());
		flight.setDestinationDate(requestFlight.getDestinationDate());
		flight.setOriginTime(requestFlight.getOriginTime());
		flight.setOriginDate(requestFlight.getOriginDate());
		flightRepository.save(flight);
	}

	@Override
	public List<ResponseFlight> getAllFlights() {
		// TODO Auto-generated method stub
		return flightRepository.findAll().stream()
				.map(flight->new ResponseFlight(flight.getFlight_number(), flight.getDestinationTime(), 
												flight.getDestinationDate(), flight.getOriginTime(), 
												flight.getOriginDate()))
				.collect(Collectors.toList());
	}

	@Override
	public ResponseFlight findFlightById(Integer id) {
		
		// Temporal
		return flightRepository.findById(id)
				.map(flight-> new ResponseFlight(flight.getFlight_number(), flight.getDestinationTime(),
						flight.getDestinationDate(),
						flight.getOriginTime(), flight.getOriginDate()))
				.get();
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
	public void updateFlight(Integer id, Date destinationTime, Date originTime) {
		Flight flight = flightRepository.getOne(id);
		flight.setDestinationTime(destinationTime);
		flight.setOriginTime(originTime);
		updateFlight(flight);
	}

}
