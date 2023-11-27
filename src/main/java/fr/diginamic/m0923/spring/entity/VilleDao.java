package fr.diginamic.m0923.spring.entity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface VilleDao {
    List<Ville> villes = new ArrayList<>();

    /**Méthode listes
     * Afficher Liste de villes dans la table
     *
     * @return
     */
    public List<Ville> listes() throws SQLException;

    /**Méthode extraireVilleById
     * Afficher une ville par son id
     *
     * @param id
     * @return
     */
    public Ville extraireVilleById(@PathVariable Integer id) throws SQLException;

    /**Méthode extraireVilleByNom
     *
     * Afficher une ville par son nom
     * @param nom
     * @return
     */
    public Ville extraireVilleByNom(@PathVariable String nom) throws SQLException;

    /**Méthode modifVille
     *
     * Modifier une ville, recherche par son id
     *
     * @param id
     * @param ville
     * @return
     *
     *
     */

    public ResponseEntity<String> modifVille(@PathVariable int id, @RequestBody Ville ville) throws SQLException;


    ////Suppression objet ville

    /**Méthode deleteVilleByID
     *
     * Suppression ville par son id
     *
     * @param id
     * @return
     */

    public ResponseEntity<String> deleteVilleById(@PathVariable int id) throws SQLException;


    ///Saisie nouvel objet ville

    /**Méthode newVille
     *
     *Ajout nouvelle ville
     *
     * @param nwVille
     * @return
     */

  public Ville newVille( @RequestBody Ville nwVille) throws SQLException;
}
