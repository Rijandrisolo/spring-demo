package fr.diginamic.m0923.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Paths;
import java.util.List;

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
        Path path = Paths.get("C:/Users/rijan/Downloads");
       List<String> lignes = Files.readAllLines(path);
        //lignes.remove(0);
        for (String ligne : lignes){
            String[] elements = ligne.split(";");
            Ville newVille =new Ville();
            newVille.setCodeDept(elements[2]);
            newVille.setNom(elements[6]);
            newVille.setNbHabitants(Integer.parseInt(elements[9].replace(" ","")));




        }

    }

}
