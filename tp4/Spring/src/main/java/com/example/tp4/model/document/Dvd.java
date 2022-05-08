package com.example.tp4.model.document;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Dvd extends Document {
    private final String TYPE = "DVD";
    private int duree;

    public Dvd(String titre, String auteur, int datePublication, String categorie, boolean disponible, int duree) {
        super(titre, auteur, datePublication, categorie, disponible);
        this.duree = duree;
    }

}
