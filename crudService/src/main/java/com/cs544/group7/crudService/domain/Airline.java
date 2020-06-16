package com.cs544.group7.crudService.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@SecondaryTable(name = "history")
@NamedQuery(
        name="Airline.getAllAirlinesOutOfAnAirport",
        query = "SELECT distinct a FROM Flight f JOIN f.airline a WHERE f.destinationAirport.code=:airportCode"
)
public class Airline {

    @Id
    @GeneratedValue
    private long id;
    @Column(length = 2, nullable = false)
    private String code;
    @Column(nullable = false)
    @Length(min = 3)
    private String name;
    @Lob
    @Column(table = "history")
    private String history;

    public Airline(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
