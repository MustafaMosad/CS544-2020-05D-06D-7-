package com.cs544.group7.crudService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs544.group7.crudService.domain.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Integer> {
	public Airline findByCode(String airlineCode);
}
