package com.cs544.group7.crudService.tests;

import com.cs544.group7.crudService.req.RequestFlight;
import com.cs544.group7.crudService.resp.ResponseFlight;
import com.cs544.group7.crudService.service.FlightService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

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
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");
        String d1 = "22-01-2015 10:15:55 AM";
        String d2 = "24-01-2015 11:40:55 AM";
        Date date;
        Date date1;
        try {
            date = formatter.parse(d1);
            date1 = formatter.parse(d2);
            RequestFlight requestFlight1 = new RequestFlight(234, 200,"KATL", date, date,"AL", date1, date1,"244");
            RequestFlight requestFlight = new RequestFlight(450, 300,"KATL", date1, date1,"AL", date, date,"234");

        } catch (ParseException e) {
            e.printStackTrace();
        }
            }


}
