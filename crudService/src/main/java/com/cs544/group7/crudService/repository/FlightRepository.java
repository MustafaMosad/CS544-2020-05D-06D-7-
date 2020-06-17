package com.cs544.group7.crudService.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cs544.group7.crudService.domain.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
	public Flight getByFlightNumber(Integer flightNumber);
	
	@Query("select f from Flight f where f.arrivalAirport.code=:arri and f.departureDate=:depDate" )
	public List<Flight> getFlightByDepartureAirportCode(String dep, @Param("arri")String arri, 
												@Param("depDate")Date depDate);
	
//	@Query("select f from Flight f join f.destinationAirport da join f.arrivalAirport aa where da.code=:dep and aa.code=:arri and f.departureDate=:depDate" )
//	public List<Flight> getFlightByDepartureAirport(@Param("dep")String dep, @Param("arri")String arri, 
//												@Param("depDate")Date depDate);
}
