package com.cs544.group7.crudService.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cs544.group7.crudService.domain.Address;
import com.cs544.group7.crudService.domain.Airport;
import com.cs544.group7.crudService.repository.AirportRepository;
import com.cs544.group7.crudService.resp.ResponseAirport;

class AirportServiceImplTests {
	
	@Mock
	AirportRepository airportRepository;
	
	@InjectMocks
	AirportServiceImpl airportServiceImpl;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetAllAirports() {
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
		
		Airport airport1 = new Airport();
		airport1.setCode("CID");
		airport1.setName("Eastern Iowa Airport");
		airport1.setAddress(airportAddress1);
		
		Airport airport2 = new Airport();
		airport2.setCode("AID");
		airport2.setName("Arizona Airport");
		airport2.setAddress(airportAddress2);
		
		List<Airport> expectedAirports = new ArrayList<>();
		expectedAirports.add(airport1);
		expectedAirports.add(airport2);
		
		when(airportRepository.findAll()).thenReturn(expectedAirports);
		
		List<ResponseAirport> actualResponseAirports = airportServiceImpl.getAllAirports();
		assertNotNull(actualResponseAirports);
		
		assertEquals(2, actualResponseAirports.size());
	}

}
