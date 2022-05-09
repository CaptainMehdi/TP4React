package com.example.tp3.model.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titre;
    private String auteur;
    private int datePublication;
    private int dureeEmprunt;
    private String categorie;
    private boolean disponible;

    public Document(String titre, String auteur, int datePublication, String categorie, boolean disponible) {
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.categorie = categorie;
        this.disponible = disponible;
    }

}
