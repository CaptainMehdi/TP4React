package com.example.tp4.DTO;

import com.example.tp4.model.document.Livre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivreDTO extends DocumentDTO {
    private String id;
    private String editeur;
    private String nombrePage;

    public LivreDTO(String id,String titre, String auteur, String datePublication, String categorie, String disponible, String editeur, String nombrePage) {
        super(titre, auteur, datePublication, categorie, disponible);
        this.editeur = editeur;
        this.nombrePage = nombrePage;
        this.id= id;
    }

    public LivreDTO(Livre livre){
        this(  Long.toString(livre.getId()),
                livre.getTitre(),
                livre.getAuteur(),
                Integer.toString(livre.getDatePublication()),
                livre.getCategorie(),
                Boolean.toString(livre.isDisponible()),
                livre.getEditeur(),
                Integer.toString(livre.getNombrePage()));
    }

}
