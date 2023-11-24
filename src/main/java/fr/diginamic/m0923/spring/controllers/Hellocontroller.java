package fr.diginamic.m0923.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")

public class Hellocontroller {

    @GetMapping
    public String DireHello(){

        return "Hello";
    }
    @GetMapping("/salut")
    public String DireSalut(){

        return "Salut";
    }

}
