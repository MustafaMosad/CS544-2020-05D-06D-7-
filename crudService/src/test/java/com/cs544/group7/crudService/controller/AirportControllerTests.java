package com.cs544.group7.crudService.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cs544.group7.crudService.domain.Address;
import com.cs544.group7.crudService.req.RequestAirport;
import com.cs544.group7.crudService.resp.ResponseAirport;
import com.cs544.group7.crudService.service.AirportService;

class AirportControllerTests {

	@Mock
	AirportService airportService;
	
	@InjectMocks
	AirportController airportController;
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetAirports() {
		Address airportAddress1 = new Address();
		airportAddress1.setStreet("Street1");
		airportAddress1.setState("IA");
		airportAddress1.setCity("City1");
		airportAddress1.setZip("23784");
		
		Address airportAddress2 = new Address();
		airportAddress2.setStreet("Street2");
		airportAddress2.setState("AZ");
		airportAddress2.setCity("City2");
		airportAddress2.setZip("23679");
		
		ResponseAirport responseAirport1 = new ResponseAirport("CID", "Eastern Iowa Airport", airportAddress1);
		ResponseAirport responseAirport2 = new ResponseAirport("AID", "Arizona Airport", airportAddress2);
		
		List<ResponseAirport> expectedResponseAirports = new ArrayList<>();
		expectedResponseAirports.add(responseAirport1);
		expectedResponseAirports.add(responseAirport2);
		
		when(airportService.getAllAirports()).thenReturn(expectedResponseAirports);
		
		List<ResponseAirport> actualResponseAirports = airportController.getAirports();
		assertNotNull(actualResponseAirports);
		
		assertEquals(2, actualResponseAirports.size() );
		
		
	}
	
	@Test
	void testAddAirport() {
		Address airportAddress1 = new Address();
		airportAddress1.setStreet("Street1");
		airportAddress1.setState("IA");
		airportAddress1.setCity("City1");
		airportAddress1.setZip("23784");
		
		RequestAirport requestAirport = new RequestAirport("CID", "Eastern Iowa Airport", airportAddress1);
		
		doAnswer((arguments) -> {
	        System.out.println("Inside doAnswer block");
	        assertEquals(requestAirport, arguments.getArgument(0));
	        return null;
	    }).when(airportService).addAirport(requestAirport);
		airportController.addAirport(requestAirport);
		
			//Alternatively
//		doNothing().when(airportService).addAirport(requestAirport);
//		airportController.addAirport(requestAirport);
	}
	
	@Test
	void testGetAirportById() {
		Address airportAddress = new Address();
		airportAddress.setStreet("Street2");
		airportAddress.setState("AZ");
		airportAddress.setCity("City2");
		airportAddress.setZip("23679");
		ResponseAirport expectedResponseAirport = new ResponseAirport("AID", "Arizona Airport", airportAddress);
		
		when(airportService.findAirportById(0L)).thenReturn(expectedResponseAirport);
		
		ResponseAirport actualResponseAirport = airportController.getAirportById(0L);
		
		assertNotNull(actualResponseAirport);
		
		assertEquals(expectedResponseAirport, actualResponseAirport);
	}
	
}
