package com.cs544.group7.crudService.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs544.group7.crudService.domain.Airport;

	@Repository
	public interface AirportRepository extends JpaRepository<Airport, Integer> {

	}