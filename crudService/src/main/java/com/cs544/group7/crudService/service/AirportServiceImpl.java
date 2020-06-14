package com.cs544.group7.crudService.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs544.group7.crudService.domain.Airport;
import com.cs544.group7.crudService.repository.AirportRepository;
@Service
@Transactional

public class AirportServiceImpl implements AirportService{
	@Autowired
	private AirportRepository airportRepository;
	@Override
	public Airport getAirportByCode(Integer id) {
		// TODO Auto-generated method stub
		return airportRepository.getAirportByCode();
	}

	@Override
	public Airport getAirportByName(String name) {
		// TODO Auto-generated method stub
		return airportRepository.getAirportByName();
	}

	@Override
	public List<Airport> getAllAirports() {
		// TODO Auto-generated method stub
		return airportRepository.findAll();
	}

}
