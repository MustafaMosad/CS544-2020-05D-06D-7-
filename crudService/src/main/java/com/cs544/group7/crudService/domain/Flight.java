package com.cs544.group7.crudService.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Flight {

    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(length = 4, nullable = false)
    private int flight_number;
    
    @Column(nullable = false)
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Airport destination;
    
    @Temporal(TemporalType.TIME)
    private Date destinationTime;
    
    @Temporal(TemporalType.DATE)
    private Date destinationDate;
    
    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Airport origin;
    
    @Temporal(TemporalType.TIME)
    private Date originTime;
    
    @Temporal(TemporalType.DATE)
    private Date originDate;
    
    @ManyToOne
    @JoinColumn(name = "airlineid")
    private Airline airline;
    
    // default constructor
    public Flight(){}
    
    // parameterized constructor

//    public Flight(int flight_number, int capacity) {
//		super();
//		this.flight_number = flight_number;
//		this.capacity = capacity;
//	}
    
    public Integer getId() {
        return id;
    }

	public void setId(Integer id) {
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
    
    public Date getDestinationTime() {
		return destinationTime;
	}
    
	public Date getDestinationDate() {
		return destinationDate;
	}

	public void setDestinationDate(Date destinationDate) {
		this.destinationDate = destinationDate;
	}
	
	public void setDestinationTime(Date destinationTime) {
		this.destinationTime = destinationTime;
	}

	public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }
    
    public Date getOriginTime() {
		return originTime;
	}

	public void setOriginTime(Date originTime) {
		this.originTime = originTime;
	}
	

	public Date getOriginDate() {
		return originDate;
	}

	public void setOriginDate(Date originDate) {
		this.originDate = originDate;
	}

	public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
