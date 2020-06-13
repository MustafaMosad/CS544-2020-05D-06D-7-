package com.cs544.group7.crudService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs544.group7.crudService.domain.Flight;
import com.cs544.group7.crudService.repository.FlightRepository;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Override
	public void addFlight(Flight flight) {
		flightRepository.save(flight);
	}

	@Override
	public List<Flight> getAllFlights() {
		// TODO Auto-generated method stub
		return flightRepository.findAll();
	}

}
