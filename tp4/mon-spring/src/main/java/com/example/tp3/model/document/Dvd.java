package com.example.tp3.model.document;

import com.example.tp3.model.document.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

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
