package com.example.tp3.model.personne;

import com.example.tp3.model.Emprunt;
import com.example.tp3.model.personne.Personne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Client extends Personne {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ToString.Exclude
    List<Emprunt> listEmprunt = new ArrayList<>();
    private double dette = 0.0;
    private double MONTANT_DETTE_JOUR = 0.25;

    public Client(String nom, String prenom, String adresse) {
        super(nom, prenom, adresse);
    }

    public void addEmprunt(Emprunt emprunt) {
        this.listEmprunt.add(emprunt);
    }

    @Override
    public String toString() {
        return "Client{" + super.toString() +
                "dette=" + dette +
                '}';
    }

    public void ajoutDette(long differenceJour) {
        double tmp = this.dette+MONTANT_DETTE_JOUR * (double) differenceJour;
        setDette(tmp);
    }

    public void retraitDette(double montant) {
        this.dette -= montant;
    }
}
