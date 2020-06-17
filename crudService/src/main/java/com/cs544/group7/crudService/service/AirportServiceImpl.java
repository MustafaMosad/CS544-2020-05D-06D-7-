package com.cs544.group7.crudService.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs544.group7.crudService.domain.Address;
import com.cs544.group7.crudService.domain.Airport;
import com.cs544.group7.crudService.repository.AirportRepository;
import com.cs544.group7.crudService.req.RequestAirport;
import com.cs544.group7.crudService.resp.ResponseAirport;
import com.cs544.group7.crudService.security.resp.TokenValidationResponse;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {

	@Autowired
	private ServletContext servletContext;

	@Autowired
	AirportRepository airportRepository;

	public void addAirport(RequestAirport requestAirport) {

		Airport airport = new Airport();
		airport.setCode(requestAirport.getCode());
		airport.setName(requestAirport.getName());
		airport.setAddress(requestAirport.getAddress());
		airportRepository.save(airport);
	}

	@Override
	public List<ResponseAirport> getAllAirports() {
		System.out.println(
				"hhhhhhhhhhhh " + ((TokenValidationResponse) servletContext.getAttribute("userInfo")).getFirstName());

		return airportRepository.findAll().stream()
				.map(airport -> new ResponseAirport(airport.getCode(), airport.getName(), airport.getAddress()))
				.collect(Collectors.toList());
	}

	@Override
	public ResponseAirport findAirportById(Long id) {
		return airportRepository.findById(id)
				.map(airport -> new ResponseAirport(airport.getCode(), airport.getName(), airport.getAddress())).get();
	}

	@Override
	public void deleteAirport(Long id) {
		airportRepository.deleteById(id);

	}

	@Override
	public void updateAirport(Airport airport) {
		airportRepository.save(airport);

	}

	@Override
	public void updateAirport(Long id, String code, String name, Address address) {
		Airport airport = airportRepository.getOne(id);
		airport.setCode(code);
		airport.setName(name);
		airport.setAddress(address);
		updateAirport(airport);

	}

}