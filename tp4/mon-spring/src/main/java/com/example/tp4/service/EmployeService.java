package com.example.tp4.service;

import com.example.tp4.DTO.*;
import com.example.tp4.model.Emprunt;
import com.example.tp4.model.document.Cd;
import com.example.tp4.model.document.Document;
import com.example.tp4.model.document.Dvd;
import com.example.tp4.model.document.Livre;
import com.example.tp4.model.personne.Client;
import com.example.tp4.repository.*;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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

    public ClientDTO saveClient(Client client) {
        clientRepository.save(client);
        return new ClientDTO(client);
    }

    public Client saveClient(String nom, String prenom, String adresse) {
        Client c = new Client(nom, prenom, adresse);
        ClientDTO dtoC = new ClientDTO(c);
        return clientRepository.save(dtoC.DTOtoClient());
    }

    public LivreDTO saveLivre(Livre livre) {
        livreRepository.save(livre);
        return new LivreDTO(livre);
    }

    public Livre saveLivre(String titre, String auteur, int datePublication, String categorie, boolean dispo, String editeur, int nombrePage) {
        Livre livre = new Livre(titre, auteur, datePublication, categorie, dispo, editeur, nombrePage);
        LivreDTO livreDTO = new LivreDTO(livre);
        return livreRepository.save(livre);
    }

    public DvdDTO saveDvd(Dvd dvd) {
        dvdRepository.save(dvd);
        return new DvdDTO(dvd);
    }

    public Dvd saveDvd(String titre, String auteur, int datePublication, String categorie, boolean dispo, int duree) {
        Dvd dvd = new Dvd(titre, auteur, datePublication, categorie, dispo, duree);
        DvdDTO dvdDTO =new DvdDTO(dvd);
        return dvdRepository.save(dvd);
    }

    public CdDTO saveCd(Cd cd) {
        cdRepository.save(cd);
        return new CdDTO(cd);
    }

    public Cd saveCd(String titre, String auteur, int datePublication, String categorie, boolean dispo, int duree) {
        Cd cd = new Cd(titre, auteur, datePublication, categorie, dispo, duree);
        CdDTO cdDTO = new CdDTO(cd);
        return cdRepository.save(cd);
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

        EmpruntDTO empruntDTO = new EmpruntDTO(emprunt);
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

        EmpruntDTO empruntDTO = new EmpruntDTO(emprunt);
        return emprunt;
    }

    @Transactional
    public EmpruntDTO createEmprunt(Emprunt emprunt) throws Exception {
        EmpruntDTO empruntDTO = new EmpruntDTO( createEmprunt((long) emprunt.getClient().getId(),(long)emprunt.getDocument().getId()));
        return empruntDTO;
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

    public List<ClientDTO> findAllClient() {
        List<ClientDTO> listeDTO = new ArrayList<>();
        for(Client c : clientRepository.findAll()){
            listeDTO.add(new ClientDTO(c));
        }

        return listeDTO;
    }

    public Optional<Client> findClientById(long id) {
        return clientRepository.findById(id);
    }

    public List<LivreDTO> findAllLivre() {
        List<LivreDTO> listeDTO = new ArrayList<>();
        for(Livre c : livreRepository.findAll()){
            listeDTO.add(new LivreDTO(c));
        }

        return listeDTO;
    }

    public List<CdDTO> findAllCd(){
        List<CdDTO> listeDTO = new ArrayList<>();
        for(Cd c : cdRepository.findAll()){
            listeDTO.add(new CdDTO(c));
        }

        return listeDTO;
    }

    public List<DvdDTO> findAllDvd(){
        List<DvdDTO> listeDTO = new ArrayList<>();
        for(Dvd dvd : dvdRepository.findAll()){
            listeDTO.add(new DvdDTO(dvd));
        }

        return listeDTO;
    }


    public List<EmpruntDTO> findAllEmprunt() {
        List<EmpruntDTO> listeDTO = new ArrayList<>();
        for(Emprunt emprunt : empruntRepository.findAll()){
            listeDTO.add(new EmpruntDTO(emprunt));
        }

        return listeDTO;
    }

    public List<DocumentDTO> findDocumentByTitre(String titre){
        List<DocumentDTO> listeDTO = new ArrayList<>();
        for(Document document : documentRepository.getDocumentByTitre(titre)){
            listeDTO.add(new DocumentDTO(document));
        }

        return listeDTO;
    }

    public List<DocumentDTO> findDocumentByAuteur(String auteur){
        List<DocumentDTO> listeDTO = new ArrayList<>();
        for(Document document : documentRepository.getDocumentByAuteur(auteur)){
            listeDTO.add(new DocumentDTO(document));
        }

        return listeDTO;
    }

    public List<DocumentDTO> findAllDocument(){
        List<DocumentDTO> listeDTO = new ArrayList<>();
        for(Document document : documentRepository.findAll()){
            listeDTO.add(new DocumentDTO(document));
        }

        return listeDTO;
    }
}
