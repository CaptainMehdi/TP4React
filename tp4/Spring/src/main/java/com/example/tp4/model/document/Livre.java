package com.example.tp4.model.document;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Livre extends Document {
    private final String TYPE = "LIVRE";
    private String editeur;
    private int nombrePage;

    public Livre(String titre, String auteur, int datePublication, String categorie, boolean disponible, String editeur, int nombrePage) {
        super(titre, auteur, datePublication, categorie, disponible);
        this.editeur = editeur;
        this.nombrePage = nombrePage;
    }


    @Override
    public String toString() {
        return "Livre{" + super.toString() +
                ", editeur='" + editeur + '\'' +
                ", nombrePage=" + nombrePage +
                '}';
    }
}
