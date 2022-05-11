package com.example.tp4.DTO;

import com.example.tp4.model.Emprunt;
import com.example.tp4.model.document.Document;
import com.example.tp4.model.personne.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpruntDTO {
    private String id;
    private String client;
    private String document;

    public EmpruntDTO(Emprunt emprunt){
        this(Long.toString(emprunt.getId()),
                Long.toString(emprunt.getClient().getId()),
                Long.toString(emprunt.getDocument().getId()));
    }

}
