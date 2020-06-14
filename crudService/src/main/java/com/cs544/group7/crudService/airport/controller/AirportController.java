package com.cs544.group7.crudService.airport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs544.group7.crudService.airport.req.RequestAirport;
import com.cs544.group7.crudService.airport.res.ResponseAirport;
import com.cs544.group7.crudService.airport.service.AirportService;
import com.cs544.group7.crudService.domain.Address;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/airports")
@Api(description = "Airport controller handles end points related to airport CRUD operations")
public class AirportController {

	@Autowired
	AirportService airportService;

	@GetMapping
	public List<ResponseAirport> getAirlines() {
		System.out.println("From here");
		return airportService.getAllAirports();
	}

	@PostMapping
	public String addFlight(@RequestBody RequestAirport requestAirport) {
		System.out.println("From here");
		airportService.addAirport(requestAirport);
		return "redirect:/airports/list";
	}

	@GetMapping(value = "/{id}")
	public ResponseAirport getAirportById(@PathVariable Integer id) {
		return airportService.findAirportById(id);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteAirport(@PathVariable Integer id) {
		airportService.deleteAirport(id);
	}

	@PutMapping(value = "/{id}")
	public String updateAirport(@PathVariable Integer id, String code, String name, Address address) {
		airportService.updateAirport(id, code, name, address);
		return "redirect:/airports/" + id;
	}

}
