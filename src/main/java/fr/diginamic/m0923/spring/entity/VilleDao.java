package fr.diginamic.m0923.spring.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;


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

    /**
     * Ville par nom
     * @param nomVille
     * @return
     */
    public Ville extractByNom(String nomVille) {

        //return em.find(Ville.class,nomVille);
        TypedQuery <Ville>  qVille = em.createQuery("Select v from Ville v where v.nom =: nom",Ville.class);
        qVille.setParameter("nom",nomVille);
        return qVille.getSingleResult();

    }

    /**
     * Ajout nouvelle ville
     *
     * @param nVille
     */
    @Transactional
    public Ville insertVille(Ville nVille){
        em.persist(nVille);
    return(nVille) ;

    }

    /**
     * Suppression Ville
     *
     * @param idVille
     * @return
     */
    public Ville supprVille(int idVille){
      Ville villeSuppr=  em.find(Ville.class,idVille);
      em.remove((villeSuppr));
      return null;
    }


}



