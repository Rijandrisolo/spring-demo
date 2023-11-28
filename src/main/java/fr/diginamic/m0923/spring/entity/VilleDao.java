package fr.diginamic.m0923.spring.entity;

import fr.diginamic.m0923.spring.controllers.Ville;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Component
public class VilleDao {

    @PersistenceContext
    private EntityManager em;


    /**
     *  listes de toutes les villes
     * Afficher Liste de villes dans la table
     *
     * @return liste ville
     */
    public List<Ville> extractAll() {

        TypedQuery<Ville> qVille = em.createQuery("Select v from Ville v",Ville.class);
        return qVille.getResultList();

    }

    /**
     * Ville by Id
     *
     * @return
     */
    public List<Ville> extractById(@PathVariable int id) {

        TypedQuery<Ville> qIdVille = (TypedQuery<Ville>) em.createQuery(("Select v from Ville WHERE id = ?"));
               return qIdVille.getResultList();
    }

    /**
     * Ajout nouvelle ville
     *
     * @param nVille
     */
    public void insertVille(Ville nVille){
        em.persist(nVille);

}
}



