package fr.diginamic.m0923.spring.entity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;




public class Ville {
    private int id;
    private String nom;
    private int nbHabitants;

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

    List<Ville> villes = new ArrayList<>();

}

