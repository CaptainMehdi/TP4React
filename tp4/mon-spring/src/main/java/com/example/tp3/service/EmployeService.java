package com.example.tp3.service;

import com.example.tp3.model.Emprunt;
import com.example.tp3.model.document.Cd;
import com.example.tp3.model.document.Document;
import com.example.tp3.model.document.Dvd;
import com.example.tp3.model.document.Livre;
import com.example.tp3.model.personne.Client;
import com.example.tp3.repository.*;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeService {
    private final int EMPRUNT_LIVRE_EN_JOURNEE = 21;
    private final int EMPRUNT_CD_EN_JOURNEE = 14;
    private final int EMPRUNT_DVD_EN_JOURNEE = 7;

    private ClientRepository clientRepository;
    private LivreRepository livreRepository;
    private DvdRepository dvdRepository;
    private CdRepository cdRepository;
    private DocumentRepository documentRepository;
    private EmpruntRepository empruntRepository;

    public EmployeService(ClientRepository clientRepository, LivreRepository livreRepository, DvdRepository dvdRepository, CdRepository cdRepository, DocumentRepository documentRepository, EmpruntRepository empruntRepository) {
        this.clientRepository = clientRepository;
        this.livreRepository = livreRepository;
        this.dvdRepository = dvdRepository;
        this.cdRepository = cdRepository;
        this.documentRepository = documentRepository;
        this.empruntRepository = empruntRepository;
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Client saveClient(String nom, String prenom, String adresse) {
        return clientRepository.save(new Client(nom, prenom, adresse));
    }

    public Livre saveLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    public Livre saveLivre(String titre, String auteur, int datePublication, String categorie, boolean dispo, String editeur, int nombrePage) {
        return livreRepository.save(new Livre(titre, auteur, datePublication, categorie, dispo, editeur, nombrePage));
    }

    public Dvd saveDvd(Dvd dvd) {
        return dvdRepository.save(dvd);
    }

    public Dvd saveDvd(String titre, String auteur, int datePublication, String categorie, boolean dispo, int duree) {
        return dvdRepository.save(new Dvd(titre, auteur, datePublication, categorie, dispo, duree));
    }

    public Cd saveCd(Cd cd) {
        return cdRepository.save(cd);
    }

    public Cd saveCd(String titre, String auteur, int datePublication, String categorie, boolean dispo, int duree) {
        return cdRepository.save(new Cd(titre, auteur, datePublication, categorie, dispo, duree));
    }

    @Transactional
    public Emprunt createEmprunt(Client client, Document document) throws Exception {
        if (!document.isDisponible()) {
            throw new Exception("Le document est deja emprunte");
        }
        setDureeDocument(document);
        Emprunt emprunt = new Emprunt(LocalDate.now(), client, document);
        emprunt.setDateRetour(LocalDate.now().plusDays(document.getDureeEmprunt()));
        client.addEmprunt(emprunt);
        document.setDisponible(false);

        return emprunt;
    }

    @Transactional
    public Emprunt createEmprunt(long clientId, long documentId) throws Exception {
        var documentOptional = documentRepository.findById(documentId);
        var clientOptional = clientRepository.findById(clientId);

        if (documentOptional.isEmpty() || clientOptional.isEmpty()) {
            throw new Exception("Pas le bon id de document ou du client");
        }
        var client = clientOptional.get();
        var document = documentOptional.get();

        if (!document.isDisponible()) {
            throw new Exception("Le document est deja emprunte");
        }

        setDureeDocument(document);
        Emprunt emprunt = new Emprunt(LocalDate.now(), client, document);
        emprunt.setDateRetour(LocalDate.now().plusDays(document.getDureeEmprunt()));
        client.addEmprunt(emprunt);
        document.setDisponible(false);

        return emprunt;
    }

    @Transactional
    public void retourDocument(Emprunt emprunt) {
        LocalDate today = LocalDate.now();
        if (emprunt.getDateRetour().compareTo(today) < 0) {
            long differenceEnJour = ChronoUnit.DAYS.between(emprunt.getDateRetour(), today);
            emprunt.getClient().ajoutDette(differenceEnJour);
        }
        emprunt.getDocument().setDisponible(true);

        clientRepository.save(emprunt.getClient());
        empruntRepository.save(emprunt);
    }

    public void setDureeDocument(Document document) {
        if (livreRepository.findById(document.getId()).isPresent()) {
            document.setDureeEmprunt(EMPRUNT_LIVRE_EN_JOURNEE);
        } else if (dvdRepository.findById(document.getId()).isPresent()) {
            document.setDureeEmprunt(EMPRUNT_DVD_EN_JOURNEE);
        } else {
            document.setDureeEmprunt(EMPRUNT_CD_EN_JOURNEE);
        }
    }

    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    public Optional<Client> findClientById(long id) {
        return clientRepository.findById(id);
    }

    public List<Livre> findAllLivre() {
        return livreRepository.findAll();
    }

    public Optional<Livre> findLivreById(long id) {
        return livreRepository.findById(id);
    }

    public List<Emprunt> findAllEmprunt() {
        return empruntRepository.findAll();
    }

    public Optional<Emprunt> findEmpruntById(long empruntId) {
        return empruntRepository.findById(empruntId);
    }

}
