package fr.diginamic.m0923.spring.controllers;


import fr.diginamic.m0923.spring.entities.Ville;
import fr.diginamic.m0923.spring.entities.VilleDao;
import fr.diginamic.m0923.spring.exceptions.GestionException;
import fr.diginamic.m0923.spring.repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/villes")

public class VilleController {
    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private VilleDao villeDao;

////////////////////////////////////

    @GetMapping
    public List<Ville> getVille(){

        return (List<Ville>) villeRepository.findAll();

    }
/////////////////////////////////////

    @GetMapping("/nom/{nomVille}")
    //public Ville findByNom(@PathVariable("nom") String nomVille){ /nom dans l'url
    public Ville findByNom(@PathVariable String nomVille) throws GestionException {
        ////
       return (Ville) villeDao.extractByNom(nomVille);
    }
////////////////////////////////////////////

    @GetMapping("/{id}")
    public Ville findById(@PathVariable int id){

        return villeDao.extractById(id);
    }
/////////////////////////////////////////

    @GetMapping("/delete/{id}")
    public Ville villeDelete(@PathVariable int id){

        villeRepository.deleteById(id);
        return null;
    }

@PutMapping("/inserer")
public  Ville insererVille(Ville nvVille) throws GestionException {

    if(nvVille.getNom() ==null){
        throw new GestionException("Erreur dans le nom de la ville");
    }
    if(nvVille.getNbHabitants()<10){
        throw new GestionException("Le nombre d'habitants doit être supérieur à 10");
    } if(nvVille.getCodeDept().length()>2){
        throw new GestionException("Le code département doit avoir au maximum 2 caractères");
    }
    ////Ville unique

    List<Ville> villes = (List<Ville>) villeRepository.findAll();
    System.out.println(villes);
    for (Ville ville : villes){
        if(nvVille.getNom()==ville.getNom() && nvVille.getCodeDept()==ville.getCodeDept()){
            throw new GestionException("La ville doit être unique dans un département");
        }

    }

    return  villeRepository.save(nvVille);
}
    @PostMapping("/update/{id}")
    public  Ville modifierVille(@PathVariable int id, @RequestBody Ville nVille) throws GestionException {

        if(id<=0){
            throw new GestionException("Id incorrect");
        }
        if(nVille.getNom() ==null){
            throw new GestionException("Erreur dans le nom de la ville");
        }
        if(nVille.getNbHabitants()<10){
            throw new GestionException("Le nombre d'habitants doit être supérieur à 10");
        }
//        System.out.println(nVille.getIddpt().length());
        if(nVille.getCodeDept().length()>2){
            throw new GestionException("Le code département doit avoir au maximum 2 caractères");
        }
            //Optional<Ville> vVille = villeRepository.findById(id);
//            System.out.println("vVille "+vVille);
            List<Ville> ville = (List<Ville>) villeRepository.findAll();
            for(Ville v : ville){
                if(v.getId()==id){
                    System.out.println(v.getNbHabitants());
                    v.setNbHabitants(nVille.getNbHabitants());
                    v.setNom(nVille.getNom());
                    v.setCodeDept(nVille.getCodeDept());
                    if(nVille.getNom()==v.getNom() && nVille.getCodeDept()==v.getCodeDept()){
                        throw new GestionException("La ville doit être unique dans un département");
                    }
                    villeRepository.save(v);
                }

            }
//            System.out.println(id);
//            System.out.println(nVille);




       return null;
    }
}












