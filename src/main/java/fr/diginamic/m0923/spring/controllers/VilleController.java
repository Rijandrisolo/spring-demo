package fr.diginamic.m0923.spring.controllers;


import fr.diginamic.m0923.spring.entities.Ville;
import fr.diginamic.m0923.spring.entities.VilleDao;
import fr.diginamic.m0923.spring.exceptions.GestionException;
import fr.diginamic.m0923.spring.exceptions.NomVilleException;
import fr.diginamic.m0923.spring.repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

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

        return villeDao.supprVille(id);
    }

@PutMapping("/inserer")
public  Ville insererVille( Ville nvVille) throws GestionException {

    if(nvVille.getNom() ==null){
        throw new GestionException("Erreur dans le nom de la ville");
    }
    if(nvVille.getNbHabitants()<10){
        throw new GestionException("Le nombre d'habitants doit être supérieur à 10");
    } if(nvVille.getIddpt().length()==2){
        throw new GestionException("Le code département doit avoir 2 caractères");
    }


    return  villeRepository.save(nvVille);
}
}












