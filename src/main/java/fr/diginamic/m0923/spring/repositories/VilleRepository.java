package fr.diginamic.m0923.spring.repositories;

import fr.diginamic.m0923.spring.entities.Ville;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VilleRepository extends CrudRepository<Ville, Integer> {


    Object findByNom(String nomVille);


}
