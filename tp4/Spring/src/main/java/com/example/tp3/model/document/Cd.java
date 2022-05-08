package com.example.tp3.model.document;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Cd extends Document {
    private final String TYPE = "CD";
    private int duree;

    public Cd(String titre, String auteur, int datePublication, String categorie, boolean disponible, int duree) {
        super(titre, auteur, datePublication, categorie, disponible);
        this.duree = duree;
    }

}
