package com.example.tp3.model.personne;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Employe extends Personne {
    public Employe(String nom, String prenom, String address) {
        super(nom, prenom, address);
    }
}
