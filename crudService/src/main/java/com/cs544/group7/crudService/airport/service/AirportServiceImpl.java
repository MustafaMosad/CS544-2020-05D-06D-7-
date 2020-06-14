package com.cs544.group7.crudService.airport.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs544.group7.crudService.airport.repository.AirportRepository;
import com.cs544.group7.crudService.airport.req.RequestAirport;
import com.cs544.group7.crudService.airport.res.ResponseAirport;
import com.cs544.group7.crudService.domain.Address;
import com.cs544.group7.crudService.domain.Airport;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {

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
		return airportRepository.findAll().stream()
				.map(airport -> new ResponseAirport(airport.getCode(), airport.getName(), airport.getAddress()))
				.collect(Collectors.toList());
	}

	@Override
	public ResponseAirport findAirportById(Integer id) {
		return airportRepository.findById(id)
				.map(airport -> new ResponseAirport(airport.getCode(), airport.getName(), airport.getAddress())).get();
	}

	@Override
	public void deleteAirport(Integer id) {
		airportRepository.deleteById(id);

	}

	@Override
	public void updateAirport(Airport airport) {
		airportRepository.save(airport);

	}

	@Override
	public void updateAirport(Integer id, String code, String name, Address address) {
		Airport airport = airportRepository.getOne(id);
		airport.setCode(code);
		airport.setName(name);
		airport.setAddress(address);
		updateAirport(airport);

	}

}