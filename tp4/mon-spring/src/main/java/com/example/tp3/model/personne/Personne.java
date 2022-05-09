package com.example.tp3.model.personne;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
public abstract class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private String prenom;
    private String address;

    public Personne(String nom, String prenom, String address) {
        this.nom = nom;
        this.prenom = prenom;
        this.address = address;
    }

}

