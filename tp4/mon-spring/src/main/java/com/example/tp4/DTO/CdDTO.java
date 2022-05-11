package com.example.tp4.DTO;

import com.example.tp4.model.document.Cd;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CdDTO extends DocumentDTO{

        private String id;
        private String duree;

        public CdDTO(String id,String titre, String auteur, String datePublication, String categorie, String disponible, String duree) {
            super(titre, auteur, datePublication, categorie, disponible);
            this.duree = duree;
            this.id= id;
        }

        public CdDTO(Cd cd){
            this(  Long.toString(cd.getId()),
                    cd.getTitre(),
                    cd.getAuteur(),
                    Integer.toString(cd.getDatePublication()),
                    cd.getCategorie(),
                    Boolean.toString(cd.isDisponible()),
                    Integer.toString(cd.getDureeEmprunt()));
        }

}
