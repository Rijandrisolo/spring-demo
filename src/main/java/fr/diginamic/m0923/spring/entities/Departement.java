package fr.diginamic.m0923.spring.entities;


import jakarta.persistence.*;

@Entity
@Table(name ="DEPARTEMENT")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddept;
    @Column(name ="nomdept")
    private String nomdept;
    @Column(name ="codedept")
    private String codedept;
    @Column(name ="nomdeptuppercase")
    private String nomdeptuppercase;
    @Column(name ="slugdept")
    private String slugdept;
    @Column(name ="nomdeptsoundex")
    private String nomdeptsoundex;

    public Departement() {
    }

    public Departement(int iddept, String nomdept, String codedept) {
        this.iddept = iddept;
        this.nomdept = nomdept;
        this.codedept = codedept;
    }

    public int getIddept() {
        return iddept;
    }

    public void setIddept(int iddept) {
        this.iddept = iddept;
    }

    public String getNomdept() {
        return nomdept;
    }

    public void setNomdept(String nomdept) {
        this.nomdept = nomdept;
    }

    public String getCodedept() {
        return codedept;
    }

    public void setCodedept(String codedept) {
        this.codedept = codedept;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "iddept=" + iddept +
                ", nomdept='" + nomdept + '\'' +
                ", codedept='" + codedept + '\'' +
                '}';
    }
}
