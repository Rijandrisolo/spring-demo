package fr.diginamic.m0923.spring.entity;


import jakarta.persistence.*;

@Entity
@Table(name ="DEPARTEMENT")
public class departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="nomdepartement")
    private String nomDepartement;

    public departement() {
    }

    public departement(int id, String nomDepartement) {
        this.id = id;
        this.nomDepartement = nomDepartement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    @Override
    public String toString() {
        return "departement{" +
                "id=" + id +
                ", nomDepartement='" + nomDepartement + '\'' +
                '}';
    }
}
