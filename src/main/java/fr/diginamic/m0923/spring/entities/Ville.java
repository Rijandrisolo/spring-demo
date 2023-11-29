package fr.diginamic.m0923.spring.entities;

import jakarta.persistence.*;

import java.util.ArrayList;

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
    private String codeDept;


    public Ville() {

    }

    public Ville(int id, String nom, int nbHabitants, String codeDept) {
        this.id = id;
        this.nom = nom;
        this.nbHabitants = nbHabitants;
        this.codeDept = codeDept;
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

    public String getCodeDept() {
        return codeDept;
    }

    public void setCodeDept(String codeDept) {
        this.codeDept = codeDept;
    }

    @Override
    public String toString() {
        return "Ville{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nbHabitants=" + nbHabitants +
                ", codeDept='" + codeDept + '\'' +
                '}';
    }

    public Ville get(int i) {
        return null;
    }
}


