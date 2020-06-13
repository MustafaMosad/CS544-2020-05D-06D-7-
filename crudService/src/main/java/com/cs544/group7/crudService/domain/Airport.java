package com.cs544.group7.crudService.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class Airport {
    @Id
    @GeneratedValue
    private long id;
    @Column(length = 3, nullable = false)
    private String code;
    @Column(nullable = false)
    @Length(min = 3)
    private String name;
    @Embedded
    private Address address;

    public Airport(){}

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
