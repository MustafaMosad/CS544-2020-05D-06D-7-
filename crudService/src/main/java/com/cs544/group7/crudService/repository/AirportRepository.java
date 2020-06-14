package com.cs544.group7.crudService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs544.group7.crudService.domain.Airport;

public interface AirportRepository extends JpaRepository<Airport, Integer> {
	public Airport findByCode(String airportCode);
}
