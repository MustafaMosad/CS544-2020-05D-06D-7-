package com.cs544.group7.crudService.service;

import com.cs544.group7.crudService.domain.Airline;
import com.cs544.group7.crudService.domain.Airport;
import com.cs544.group7.crudService.repository.AirlineRespository;
import com.cs544.group7.crudService.req.AirlineRequest;
import com.cs544.group7.crudService.resp.AirlineResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AirlineServiceImp implements AirlineService {

    @Autowired
    AirlineRespository airlineRespository;

    @Override
    public void saveAirline(AirlineRequest airlineRequest) {
        Airline airline = new Airline();
        airline.setCode(airlineRequest.getCode());
        airline.setName(airlineRequest.getName());
        airline.setHistory(airlineRequest.getHistory());

        airlineRespository.save(airline);

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
    public List<AirlineResponse> getAirlineByAirportCode(String airportCode) {
        return convertAirlineListToAirlineResponseList(airlineRespository.getAllAirlinesOutOfAnAirport(airportCode));
    }


    @Override
    public List<AirlineResponse> getAllAirlines() {
        return airlineRespository.findAll().stream().parallel()
                .map(this::convertAirlineToAirlineResponse)
                .collect(Collectors.toList());

    }

    @Override
    public void deleteAirline(Long id) {
        airlineRespository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        airlineRespository.deleteAll();
    }

    @Override
    public void updateAirline(Airline airline) {
        airlineRespository.save(airline);
    }

    @Override
    public void updateAirline(Long id, String code, String name) {
        Airline airline = airlineRespository.getOne(id);
        airline.setCode(code);
        airline.setName(name);

        updateAirline(airline);

    }

    private AirlineResponse convertAirlineToAirlineResponse(Airline airline) {
        return new AirlineResponse(airline.getCode(),airline.getName(), airline.getHistory());
    }

    private List<AirlineResponse> convertAirlineListToAirlineResponseList(List<Airline> airline) {
        AirlineResponse airlineResponse;
        List<AirlineResponse> responseList = new ArrayList<>();
        for(Airline a : airline){
            airlineResponse = new AirlineResponse(a.getCode(),a.getName(), a.getHistory());
            responseList.add(airlineResponse);
        }
        return responseList;
    }

}
