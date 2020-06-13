package com.cs544.group7.crudService.domain;

import javax.persistence.*;

@Entity
public class Flight {

    @Id
    @GeneratedValue
    private long id;
    
    @Column(length = 4, nullable = false)
    private int flight_number;
    
    @Column(nullable = false)
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Airport destination;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Airport origin;
    
    @ManyToOne
    @JoinColumn(name = "airlineid")
    private Airline airline;
    
    // default constructor
    public Flight(){}
    
    // parameterized constructor
    
    public long getId() {
        return id;
    }

    public Flight(int flight_number, int capacity) {
		super();
		this.flight_number = flight_number;
		this.capacity = capacity;
	}

	public void setId(long id) {
        this.id = id;
    }

    public int getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
