package com.cs544.group7.crudService.service;

import com.cs544.group7.crudService.domain.Airline;
import com.cs544.group7.crudService.service.response.AirlineResponse;

import java.util.List;

public interface AirlineService {

    List<Airline> saveAllAirlines(List<Airline> airlines);

    Airline saveAirline(Airline airline);

    AirlineResponse getAirlineById(Long id);

    AirlineResponse getAirlineByName(String name);

    List<AirlineResponse> getAllAirlines();

    void deleteAirline(Airline airline);

    void deleteAll();
}
