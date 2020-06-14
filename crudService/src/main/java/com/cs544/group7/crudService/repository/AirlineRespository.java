package com.cs544.group7.crudService.repository;

import com.cs544.group7.crudService.domain.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRespository extends JpaRepository<Airline, Long> {

	Airline findByName(String name);

	public Airline findByCode(String airlineCode);

}
