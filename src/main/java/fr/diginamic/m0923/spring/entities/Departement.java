package fr.diginamic.m0923.spring.entities;


import jakarta.persistence.*;

@Entity
@Table(name ="DEPARTEMENT")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="nomdepartement")
    private String nomDepartement;
    private String codeDepartement;

    public Departement() {
    }

    public Departement(int id, String nomDepartement, String codeDepartement) {
        this.id = id;
        this.nomDepartement = nomDepartement;
        this.codeDepartement = codeDepartement;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", nomDepartement='" + nomDepartement + '\'' +
                ", codeDepartement='" + codeDepartement + '\'' +
                '}';
    }
}
