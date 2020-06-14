package com.cs544.group7.crudService.airport.res;

import com.cs544.group7.crudService.domain.Address;

public class ResponseAirport {

	    private String code;
	    private String name;
	    private Address address;
	    
	  //parameter less constructor
		public ResponseAirport() {}
		
		//parameterized constructor 
		public ResponseAirport(String code, String name, Address address) 
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
