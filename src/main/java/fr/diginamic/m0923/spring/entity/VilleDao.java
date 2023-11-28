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
     * Select Ville by Id
     *
     * @return
     */
     public Ville  extractById(int id) {

         return em.find(Ville.class,id);
     }

    public Ville extractByNom(String nomVille) {

        //return em.find(Ville.class,nomVille);
        TypedQuery<Ville> qVille = em.createQuery("Select v from Ville v where v.nom =: nom",Ville.class);
        qVille.setParameter("nom",nomVille);
        return qVille.getSingleResult().get(0);

    }

    /**
     * Ajout nouvelle ville
     *
     * @param nVille
     */
    @Transational
    public insertVille(Ville nVille){
        em.persist(nVille);
        return

}


}



