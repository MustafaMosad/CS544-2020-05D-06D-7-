package com.cs544.group7.crudService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs544.group7.crudService.domain.Airport;
import com.cs544.group7.crudService.service.AirportService;

@RestController
@RequestMapping("/airports")
public class AirportController {
	@Autowired
	private AirportService airportService;
	
	@GetMapping("/list")
	public List<Airport> getAllAirports(){
		return airportService.getAllAirports();
	}
	
	@GetMapping("{/id}")
	public Airport getAirportByCode(@PathVariable Integer id) {
		return airportService.getAirportByCode(id);
		
	}
	
	public Airport getAirportByName(@PathVariable String name) {
		return airportService.getAirportByName(name);
	}

}
