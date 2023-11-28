package fr.diginamic.m0923.spring.controllers;


import fr.diginamic.m0923.spring.entity.VilleDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/villes")

public class VilleController {
    @Autowired
    private VilleDao villeDao;

////////////////////////////////////

    @GetMapping
    public List<Ville> getVille(){

        return villeDao.extractAll();

    }
/////////////////////////////////////

    @GetMapping("/nom/{nom}")
    public Ville findByNom(@PathVariable String nomVille){

        return villeDao.extractByNom(nomVille);
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

}












