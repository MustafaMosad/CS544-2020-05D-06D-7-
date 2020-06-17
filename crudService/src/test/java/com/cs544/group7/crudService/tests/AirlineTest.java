package com.cs544.group7.crudService.tests;

import com.cs544.group7.crudService.req.AirlineRequest;
import com.cs544.group7.crudService.resp.AirlineResponse;
import com.cs544.group7.crudService.service.AirlineService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan("com.cs544.group7.crudService.service")
public class AirlineTest {

    AirlineResponse response1;
    AirlineResponse response2;

    @Autowired
    AirlineService service;

    @Before
    public void setUp(){
        // given
        AirlineRequest airline = new AirlineRequest("UA","United Airlines","United Airlines has been serving for over 100 years");
        AirlineRequest airline1 = new AirlineRequest("EA", "Emirates Airlines","Emirates Airlines has been serving for over 200 years");

        response1 = service.saveAirline(airline);
        response2 = service.saveAirline(airline1);
    }

    @Test
    public void whenFindByName_thenReturnAirline() {
        // when
        AirlineResponse airlineByName = service.getAirlineByName(response2.getName());

        // then
        assertThat(airlineByName.getName()).isEqualTo(response2.getName());
    }

    @Test
    public void whenFindById_thenReturnAirline() {
        // when
        AirlineResponse airlineById = service.getAirlineById(response1.getId());

        // then
        assertThat(airlineById.getId()).isEqualTo(response1.getId());
    }

    @Test
    public void whenFindAll_thenReturnAirlineList() {
        // when
        List<AirlineResponse> airlines = service.getAllAirlines();

        // then
        assertThat(airlines).hasSize(2);
    }

    @Test
    public void updateAirlineTest(){
        String name = "Emirates";
        service.updateAirline(response2.getId(), response2.getCode(), name);
        AirlineResponse r = service.getAirlineById(response2.getId());
        assertThat(r.getName()).isEqualTo(name);

    }

    @Test
    public void deleteAirline(){

        AirlineRequest a = new AirlineRequest("BR", "Brussels","Brussels Airlines has been serving for over 150 years");
        AirlineResponse res = service.saveAirline(a);

        AirlineResponse s = service.getAirlineById(res.getId());
        assertThat(s.getId()).isEqualTo(res.getId());

        service.deleteAirline(res.getId());
        Assertions.assertThrows(Exception.class, ()-> service.getAirlineById(res.getId()));
    }

//    @Test
//    public void deleteAllAirlines(){
//        AirlineRequest a = new AirlineRequest("BR", "Brussels","Brussels Airlines has been serving for over 150 years");
//        AirlineRequest b = new AirlineRequest("TR", "Turkish","Turkish Airlines has been serving for over 150 years");
//        service.saveAirline(a);
//        service.saveAirline(b);
//
//        service.deleteAll();
//        Assertions.assertEquals((double) service.getAllAirlines().toArray().length, null);
//    }

}
