package com.example.tp4.DTO;

import com.example.tp4.model.personne.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private String id;
    private String nom;
    private String prenom;
    private String adresse;

    public ClientDTO(Client member){
        this(Long.toString(member.getId()), member.getNom(), member.getPrenom(), member.getAddress());
    }

    public Client DTOtoClient(){
        return new Client(getNom(), getPrenom(), getAdresse());
    }
}
