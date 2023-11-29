package fr.diginamic.m0923.spring;

import fr.diginamic.m0923.spring.services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TraitementFichier implements CommandLineRunner {

    @Autowired
    private VilleService villeService;

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(TraitementFichier.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }
    @Override
    public void run (String... args) throws Exception{

    }

}
