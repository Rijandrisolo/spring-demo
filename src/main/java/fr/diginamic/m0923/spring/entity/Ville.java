package fr.diginamic.m0923.spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="VILLE")
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="nom")
    private String nom;
    @Column(name="nbhabitants")
    private int nbHabitants;

    public Ville() {
    }

    public Ville(int id, String nom, int nbHabitants) {
        this.id = id;
        this.nom = nom;
        this.nbHabitants = nbHabitants;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getNom() {

        return nom;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }

    public int getNbHabitants() {
        return nbHabitants;
    }

    public void setNbHabitants(int nbHabitants) {

        this.nbHabitants = nbHabitants;
    }

    @Override
    public String toString() {
        return "Ville :" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nbHabitants=" + nbHabitants
                ;
    }

    public Ville get(int i) {
        return null;
    }
}


