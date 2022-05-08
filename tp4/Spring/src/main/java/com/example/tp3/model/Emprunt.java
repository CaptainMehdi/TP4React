package com.example.tp3.model;

import com.example.tp3.model.document.Document;
import com.example.tp3.model.personne.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate dateEmprunt;
    private LocalDate dateRetour;

    @ManyToOne
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    private Document document;

    public Emprunt(LocalDate dateEmprunt, Client client, Document document) {
        this.dateEmprunt = dateEmprunt;
        this.client = client;
        this.document = document;
        dateRetour = null;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }
}