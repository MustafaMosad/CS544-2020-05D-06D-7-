package com.cs544.group7.crudService.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.cs544.group7.crudService.domain.Address;
import com.cs544.group7.crudService.req.RequestAirport;
import com.cs544.group7.crudService.resp.ResponseAirport;
import com.cs544.group7.crudService.service.AirportService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/airports")
@Api(description = "Airport controller handles end points related to airport CRUD operations")
public class AirportController {

	@Autowired
	AirportService airportService;

	@GetMapping
	public List<ResponseAirport> getAirports() {
		System.out.println("From here");
		return airportService.getAllAirports();
	}

	@PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
	public String addAirport(@RequestBody RequestAirport requestAirport) {
		System.out.println("From here");
		airportService.addAirport(requestAirport);
		return "redirect:/airports/list";
	}

	@GetMapping(value = "/{id}")
	public ResponseAirport getAirportById(@PathVariable Long id) {
		return airportService.findAirportById(id);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteAirport(@PathVariable Long id) {
		airportService.deleteAirport(id);
	}

	@PutMapping(value = "/{id}")
	public String updateAirport(@PathVariable Long id, String code, String name, Address address) {
		airportService.updateAirport(id, code, name, address);
		return "redirect:/airports/" + id;
	}

}
