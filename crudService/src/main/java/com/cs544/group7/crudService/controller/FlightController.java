package com.cs544.group7.crudService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs544.group7.crudService.domain.Flight;
import com.cs544.group7.crudService.service.FlightService;

@RestController
@RequestMapping(value="flights")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@GetMapping(value="list")
	public List<Flight> getFlights(){
		System.out.println("From here");
		return flightService.getAllFlights();
	}
	@PostMapping(value="/add")
	public String addFlight(Flight flight) {
		System.out.println("From here");
		flightService.addFlight(flight);
		return "redirect:/flights/list";
	}
}
