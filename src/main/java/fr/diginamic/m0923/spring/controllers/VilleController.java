package fr.diginamic.m0923.spring.controllers;


import fr.diginamic.m0923.spring.entity.Ville;
import fr.diginamic.m0923.spring.entity.VilleDao;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/villes")

public class VilleController implements VilleDao{

    @GetMapping
    @Override
    public Ville newVille(Ville nwVille) throws SQLException {
        return null;
    }
    ////liste villes

    /**Méthode listes
     * Afficher Liste de villes dans la table
     *
     * @return
     */

    @GetMapping
    @Override
    public List<Ville> listes() {


       return villes;
    }
    ///////liste ville byId

    /**Méthode extraireVilleById
     * Afficher une ville par son id
     *
     * @param id
     * @return
     */

   @GetMapping("/id/{id}")
   @Override
   public Ville extraireVilleById(@PathVariable Integer id) {
        Ville villeById=null;

       for(Ville ville : villes){

            if(ville.getId() == id){
                villeById=ville;

            }

       }
        return villeById;
    }
    ///Liste ville by nom

    /**Méthode extraireVilleByNom
     *
     * Afficher une ville par son nom
     * @param nom
     * @return
     */

   @GetMapping("/{nom}")
   @Override
   public Ville extraireVilleByNom(@PathVariable String nom) {
    Ville villeByNom=null;
       for(Ville ville : villes){

            if(ville.getNom().equals(nom) ){
                villeByNom=ville;

            }
        }
       return villeByNom;

    }

    /// Modification objet ville
    /**Méthode modifVille
     *
     * Modifier une ville, recherche par son id
     *
     * @param id
     * @param ville
     * @return
     *
     */

    @PostMapping("/{id}")
    @Override
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


///Saisie nouvel objet ville
//    @PutMapping
//  public Ville newVille( @RequestBody Ville nwVille){
//
//
//
//       for(Ville ville : villes){
//           if(ville.getId()== nwVille.getId()){
//               return ResponseEntity.badRequest().body("Ville existante");
//           }else {
//                villes.add(new Ville(nwVille));
//                return
//               return ResponseEntity.ok().body("Ville ajoutée");
//           }
//        }return null;
//
//    }

 ////Suppression objet ville

    /**Méthode deleteVilleByID
     *
     * Suppression ville par son id
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<String> deleteVilleById(@PathVariable int id){
        if (id<=0){
            return ResponseEntity.badRequest().body("Identifiant incorrect");
        }
        Iterator<Ville> iteVille=villes.iterator();
        while (iteVille.hasNext()){
            Ville v = iteVille.next();
            if (v.getId() == id){
                iteVille.remove();
                ResponseEntity.ok().body("Ville supprimée");
            }

        }
        return ResponseEntity.badRequest().body("Non trouvée");
    }



}












