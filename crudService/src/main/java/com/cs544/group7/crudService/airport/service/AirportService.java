package com.cs544.group7.crudService.airport.service;

import java.util.List;

import com.cs544.group7.crudService.airport.req.RequestAirport;
import com.cs544.group7.crudService.airport.res.ResponseAirport;
import com.cs544.group7.crudService.domain.Address;
import com.cs544.group7.crudService.domain.Airport;
	
	public interface AirportService {
		
		public void addAirport(RequestAirport requestAirport);
		
		public List<ResponseAirport> getAllAirports();
		
		public ResponseAirport findAirportById(Integer id);
		
		public void deleteAirport(Integer id);
		
		public void updateAirport(Airport airport);
		
		public void updateAirport(Integer id, String code, String name, Address address);
	}
