package com.cs544.group7.crudService.service;

import java.util.List;

import com.cs544.group7.crudService.domain.Airport;

public interface AirportService {
	Airport getAirportByCode(Integer id);
	Airport getAirportByName(String name);
	List<Airport> getAllAirports();

}
