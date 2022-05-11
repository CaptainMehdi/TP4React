package com.example.tp4.DTO;

import com.example.tp4.model.document.Dvd;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DvdDTO extends DocumentDTO {

    private String id;
    private String duree;

    public DvdDTO(String id,String titre, String auteur, String datePublication, String categorie, String disponible, String duree) {
        super(titre, auteur, datePublication, categorie, disponible);
        this.duree = duree;
        this.id= id;
    }

    public DvdDTO(Dvd dvd){
        this(  Long.toString(dvd.getId()),
                dvd.getTitre(),
                dvd.getAuteur(),
                Integer.toString(dvd.getDatePublication()),
                dvd.getCategorie(),
                Boolean.toString(dvd.isDisponible()),
                Integer.toString(dvd.getDureeEmprunt()));
    }
}
