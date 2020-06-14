package com.cs544.group7.crudService.service.implementation;

import com.cs544.group7.crudService.domain.Airline;
import com.cs544.group7.crudService.repository.AirlineRespository;
import com.cs544.group7.crudService.service.AirlineService;
import com.cs544.group7.crudService.service.response.AirlineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AirlineServiceImp implements AirlineService {

    @Autowired
    AirlineRespository airlineRespository;


    @Override
    public List<Airline> saveAllAirlines(List<Airline> airlines) {
        return airlineRespository.saveAll(airlines);
    }

    @Override
    public Airline saveAirline(Airline airline) {
        return airlineRespository.save(airline);
    }

    @Override
    public AirlineResponse getAirlineById(Long id) {

        return airlineRespository.findById(id).map(this::convertAirlineToAirlineResponse).get();
    }

    @Override
    public AirlineResponse getAirlineByName(String name) {
        return convertAirlineToAirlineResponse(airlineRespository.findByName(name));
    }

    @Override
    public List<AirlineResponse> getAllAirlines() {

        return airlineRespository.findAll().stream().parallel()
                .map(this::convertAirlineToAirlineResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAirline(Airline airline) {
        airlineRespository.delete(airline);
    }

    @Override
    public void deleteAll() {
        airlineRespository.deleteAll();
    }

    private AirlineResponse convertAirlineToAirlineResponse(Airline airline) {
        return new AirlineResponse(airline.getId(), airline.getCode(),airline.getName(), airline.getHistory());
    }
}
