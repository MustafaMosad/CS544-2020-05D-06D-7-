package com.cs544.group7.crudService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs544.group7.crudService.domain.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
