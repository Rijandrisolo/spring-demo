package fr.diginamic.m0923.spring.controllers;

import fr.diginamic.m0923.spring.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloservice;

    @GetMapping
    public String DireHello(){

        return helloservice.salutations();
    }
    @GetMapping("/salut")
    public String DireSalut(){

        return "Salut";
    }

}
