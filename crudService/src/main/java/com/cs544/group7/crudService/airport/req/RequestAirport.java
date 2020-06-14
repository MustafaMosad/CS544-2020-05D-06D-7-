package com.cs544.group7.crudService.airport.req;

import com.cs544.group7.crudService.domain.Address;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "All details about requested airport ")
public class RequestAirport {

	    private String code;
	    private String name;
	    private Address address;
	    
	  //parameter less constructor
		public RequestAirport() {}
		
		//parameterized constructor 
		public RequestAirport(String code, String name, Address address) 
		{
			super();
			this.code = code;
			this.name = name;
			this.address = address;
			
		}
		
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}

	    
}
