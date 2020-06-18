package com.cs544.group7.crudService.controller;

import com.cs544.group7.crudService.domain.Airline;
import com.cs544.group7.crudService.req.AirlineRequest;
import com.cs544.group7.crudService.resp.AirlineResponse;
import com.cs544.group7.crudService.service.AirlineService;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/airlines")
@Api(description = "Airline Controller handles all endpoints related to Airline Crud Operations")
public class AirlineController {

    @Autowired
    AirlineService airlineService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void saveAirline(@RequestBody AirlineRequest airline){

        airlineService.saveAirline(airline);
    }

    @GetMapping("/{id}")
    public AirlineResponse getAirlineById(@PathVariable Long id){
       return airlineService.getAirlineById(id);
    }

    @GetMapping(params = {"name"})
    public AirlineResponse getAirlineByName(@RequestParam String name){
        return airlineService.getAirlineByName(name);
    }

    @GetMapping
    public List<AirlineResponse> getAllAirlines(){

        return airlineService.getAllAirlines();
    }

    @DeleteMapping("/{id}")
    public void deleteAirline(@PathVariable Long id){
        airlineService.deleteAirline(id);
    }

    @DeleteMapping
    public void deleteAllAirlines(){
        airlineService.deleteAll();
    }

    @PutMapping("/{id}")
    public void updateAirline(@PathVariable Long id, String code, String name){
        airlineService.updateAirline(id, code, name);
    }

    @GetMapping(params = {"airlineCode"})
    public List<AirlineResponse> getAirlineByAirportCode(@RequestParam String airlineCode){
        return airlineService.getAirlineByAirportCode(airlineCode);
    }

}
