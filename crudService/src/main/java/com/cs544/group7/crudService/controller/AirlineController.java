package com.cs544.group7.crudService.controller;

import com.cs544.group7.crudService.domain.Airline;
import com.cs544.group7.crudService.service.AirlineService;
import com.cs544.group7.crudService.service.response.AirlineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.List;

@RestController
@RequestMapping("/airline")
public class AirlineController {

    @Autowired
    AirlineService airlineService;

    @PostMapping(value = "/saveAirline")
    public Airline saveAirline(@RequestBody Airline airline){

        return airlineService.saveAirline(airline);
    }

    @PostMapping(value = "/saveAirlines")
    public List<Airline> saveAllAirlines(@RequestBody List<Airline> airlines){
        return airlineService.saveAllAirlines(airlines);
    }

    @GetMapping("/{id}")
    public AirlineResponse getAirlineById(@PathVariable Long id){
       return airlineService.getAirlineById(id);
    }

    @GetMapping(params = {"name"})
    public AirlineResponse getAirlineByName(@RequestParam String name){
        return airlineService.getAirlineByName(name);
    }

    @GetMapping("/allAirlines")
    public List<AirlineResponse> getAllAirlines(){
        return airlineService.getAllAirlines();
    }

    @DeleteMapping(params = {"airline"})
    public void deleteAirline(@RequestParam Airline airline){
        airlineService.deleteAirline(airline);
    }

    @DeleteMapping("/")
    public void deleteAllAirlines(){
        airlineService.deleteAll();
    }


}
