package fr.diginamic.m0923.spring.controllers;


import fr.diginamic.m0923.spring.entity.Ville;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleController {
    List<Ville> villes = new ArrayList<>();

    public VilleController(List<Ville> villes) {

        this.villes = villes;
        villes.add(new Ville(1, "Nice", 343000));
        villes.add(new Ville(2, "Carcassonne", 47800));
        villes.add(new Ville(3, "Narbonne", 53400));
        villes.add(new Ville(4, "Lyon", 484000));
        villes.add(new Ville(5, "Foix", 9700));
        villes.add(new Ville(6, "Pau", 77200));
        villes.add(new Ville(7, "Marseille", 850700));
        villes.add(new Ville(8, "Tarbes", 40600));

    }

    public List<Ville> getVilles() {
        return villes;
    }

    public void setVilles(List<Ville> villes) {
        this.villes = villes;
    }

    @GetMapping
    public List<Ville> listes() {
        return villes;
    }

   @GetMapping("/id/{id}")
   public Ville extraireVille(@PathVariable Integer id) {
        Ville villeById=null;

       for(Ville ville : villes){

            if(ville.getId() == id){
                villeById=ville;

            }

       }
        return villeById;
    }
   @GetMapping("/{nom}")
   public Ville nomVille(@PathVariable String nom) {
    Ville villeByNom=null;
       for(Ville ville : villes){

            if(ville.getNom().equals(nom) ){
                villeByNom=ville;

            }
        }
       return villeByNom;

    }
    @PostMapping("/{id}")
    public ResponseEntity<String> modifVille(@PathVariable int id, @RequestBody Ville ville){
        if (id<=0){
            return ResponseEntity.badRequest().body("Identifiant incorrect");
        }
        for (Ville v : villes){
            if (v.getId()==id){
                v.setNom(ville.getNom());
                v.setNbHabitants(ville.getNbHabitants());
                return ResponseEntity.ok("Ville modifiée");

            }

        }
    return ResponseEntity.badRequest().body("Non trouvée");
    }



//    @PutMapping
//    public Ville newVille( @RequestBody Ville newVille){
//
//
//
//        for(Ville ville : villes){
//            if(ville.getNom().equals(newNom) ){
//                System.out.println("La ville existe déjà");
//            }else {
//                villes.add(new Ville(newVille));
//                System.out.println("La ville est créée");
//            }
//        }
//     return null;
//
//
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVille(@PathVariable int id){
        if (id<=0){
            return ResponseEntity.badRequest().body("Identifiant incorrect");
        }
        for (Ville v : villes){
            if (v.getId()==id){

               return ResponseEntity.ok("Ville supprimée");

            }

        }
        return ResponseEntity.badRequest().body("Non trouvée");
    }

}












