package fr.diginamic.m0923.spring.services;

import org.springframework.stereotype.Component;

@Component
public class HelloService {


    public String salutations(){

        return "Je suis la classe de service et je vous dis bonjour";

    }
}
