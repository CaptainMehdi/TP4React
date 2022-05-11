package com.example.tp4.DTO;

import com.example.tp4.model.document.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class DocumentDTO {

    private String id;
    private String titre;
    private String auteur;
    private String datePublication;
    private String categorie;
    private String disponible;

    public DocumentDTO(Document document){
        this(Long.toString(document.getId()),
                document.getTitre(),
                document.getAuteur(),
                Integer.toString(document.getDatePublication()),
                document.getCategorie(),
                Boolean.toString(document.isDisponible()));
    }

    public DocumentDTO(String titre, String auteur, String datePublication, String categorie, String disponible) {
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.categorie = categorie;
        this.disponible = disponible;
    }

}
