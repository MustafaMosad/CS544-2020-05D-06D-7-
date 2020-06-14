package com.cs544.group7.crudService.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class Rootcontroller {

    @RequestMapping(method = RequestMethod.GET)
    public String SwaggerUi(){
        return "redirect:/swagger-ui.html";
    }
}

