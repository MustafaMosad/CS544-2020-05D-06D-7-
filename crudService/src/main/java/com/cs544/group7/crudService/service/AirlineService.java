package com.cs544.group7.crudService.service;

import com.cs544.group7.crudService.domain.Airline;
import com.cs544.group7.crudService.domain.Airport;
import com.cs544.group7.crudService.req.AirlineRequest;
import com.cs544.group7.crudService.resp.AirlineResponse;

import java.util.List;

public interface AirlineService {

    void saveAirline(AirlineRequest airline);

    AirlineResponse getAirlineById(Long id);

    AirlineResponse getAirlineByName(String name);

    List<AirlineResponse> getAirlineByAirportCode(String airportCode);

    List<AirlineResponse> getAllAirlines();

    void deleteAirline(Long id);

    void deleteAll();

    void updateAirline(Airline airline);

    void updateAirline(Long id, String code, String name);
}
