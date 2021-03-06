package com.cs544.group7.crudService.service;

import java.util.Date;
import java.util.List;

import com.cs544.group7.crudService.domain.Flight;
import com.cs544.group7.crudService.req.RequestFlight;
import com.cs544.group7.crudService.resp.ResponseFlight;

public interface FlightService {
	
	public ResponseFlight addFlight(RequestFlight requestFlight);
	
	public List<ResponseFlight> getAllFlights();
	
	public ResponseFlight findFlightById(Integer id);
	
	public void deleteFlight(Integer id);
	
	public void updateFlight(Flight flight);
	
	public void updateFlight(Integer id, Date departureTime, Date arrivalTime);
	
	public ResponseFlight findFlightByFlightNumber(Integer flightNumber);
	
	List<ResponseFlight> getFlightByDepartureAirportCode(String departureAirPortCode, String arrivalAirPortCode, Date departureDate);
}
