package com.cs544.group7.crudService.tests;

import com.cs544.group7.crudService.req.RequestFlight;
import com.cs544.group7.crudService.resp.ResponseFlight;
import com.cs544.group7.crudService.service.FlightService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan("com.cs544.group7.crudService.service")
public class FlightTest {

    ResponseFlight responseFlight1;
    ResponseFlight responseFlight2;

    @Autowired
    FlightService service;

    @Before
    public void setUp(){
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String d1 = "22-01-2015 10:15:55";
        String d2 = "24-01-2015 11:40:55";
        Date date = null;
        Date date1 = null;
        try {
            date = formatter.parse(d1);
            date1 = formatter.parse(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        RequestFlight requestFlight = new RequestFlight(234, 200,"KATL", date, date,"AL", date1, date1,"001");
        RequestFlight requestFlight1 = new RequestFlight(450, 300,"LAX", date1, date1,"HND", date, date,"234");
        responseFlight1 = service.addFlight(requestFlight);
        responseFlight2 = service.addFlight(requestFlight1);
    }

    @Test
    public void whenFindById_thenReturnFlight() {
        // when
        ResponseFlight flightById = service.findFlightById(responseFlight1.getId());

        // then
        assertThat(flightById.getId()).isEqualTo(responseFlight1.getId());
    }

    @Test
    public void whenFindAll_thenReturnFlightList() {
        // when
        List<ResponseFlight> allFlights = service.getAllFlights();

        // then
        assertThat(allFlights).hasSize(2);
    }

    @Test
    public void updateFlight(){
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String d = "26-01-2016 12:00:00";
        Date date = null;
        try {
            date = formatter.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        service.updateFlight(responseFlight2.getId(),date ,responseFlight2.getArrivalTime());
        ResponseFlight f = service.findFlightById(responseFlight2.getId());
        assertThat(f.getDestinationTime()).isEqualTo(date);
    }

    @Test
    public void deleteFlight(){

        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String d1 = "22-01-2015 10:15:55";
        String d2 = "24-01-2015 11:40:55";
        Date date = null;
        Date date1 = null;
        try {
            date = formatter.parse(d1);
            date1 = formatter.parse(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        RequestFlight req = new RequestFlight(234, 200,"PEK", date, date,"HND", date1, date1,"001");
        ResponseFlight res = service.addFlight(req);

        ResponseFlight f = service.findFlightById(res.getId());
        assertThat(f.getId()).isEqualTo(res.getId());

        service.deleteFlight(res.getId());
        Assertions.assertThrows(Exception.class, ()-> service.findFlightById(res.getId()));
    }

}
