package com.cs544.group7.crudService.service;

import java.util.List;

import com.cs544.group7.crudService.domain.Flight;

public interface FlightService {
	
	public void addFlight(Flight flight);
	
	public List<Flight> getAllFlights();

}
