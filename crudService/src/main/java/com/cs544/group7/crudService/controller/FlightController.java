package com.cs544.group7.crudService.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cs544.group7.crudService.req.RequestFlight;
import com.cs544.group7.crudService.resp.ResponseFlight;
import com.cs544.group7.crudService.service.FlightService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/flights")
@Api(description="Flight controller handles end points related to flight CRUD operations")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@GetMapping
	public List<ResponseFlight> getFlights(){
		
		return flightService.getAllFlights();
	}
	@PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
	public String addFlight(@RequestBody RequestFlight requestFlight) {
		
		flightService.addFlight(requestFlight);
		return "redirect:/flights/list";
	}
	
	@GetMapping(value="/{id}")
	public ResponseFlight getFlightById(@PathVariable Integer id) {
		return flightService.findFlightById(id);
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteFlight(@PathVariable Integer id) {
		flightService.deleteFlight(id);
	}
	
	@PutMapping(value = "/{id}", params = {"departureTime", "arrivalTime"})
	public String updateFlight(@PathVariable Integer id, @RequestParam Date departureTime, @RequestParam Date arrivalTime) {
		
		flightService.updateFlight(id, departureTime, arrivalTime);
		return "redirect:/flights/" + id;
	}
	
	@GetMapping(value="/flightsPerdayBetweenAirports", params= {"departureAirPortCode", "arrivalAirPortCode", "departureDate"})
	public List<ResponseFlight> findAllFlightBetweenDepartureAirportAndArrivalAirport(String departureAirPortCode, String arrivalAirPortCode, Date departureDate){
		return flightService.getFlightByDepartureAirportCode(departureAirPortCode, arrivalAirPortCode, departureDate);
	}
	
	@GetMapping(value="/flight/{flightNumber}")
	public ResponseFlight getFlightByFlightNumber(@PathVariable Integer flightNumber) {
		return flightService.findFlightByFlightNumber(flightNumber);
	}
}
