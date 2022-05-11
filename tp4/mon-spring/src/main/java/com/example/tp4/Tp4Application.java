package com.example.tp4;

import com.example.tp4.model.Emprunt;
import com.example.tp4.model.document.Cd;
import com.example.tp4.model.document.Livre;
import com.example.tp4.model.personne.Client;
import com.example.tp4.repository.ClientRepository;
import com.example.tp4.repository.DocumentRepository;
import com.example.tp4.repository.LivreRepository;
import com.example.tp4.service.ClientService;
import com.example.tp4.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Tp4Application implements CommandLineRunner {

    @Autowired
    private EmployeService es;

    @Autowired
    private ClientService cs;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private DocumentRepository documentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        final Client client = es.saveClient("mehdi", "popo", "39 rue monge");
        final Client client1 = es.saveClient("teo", "dort", "48 rue louge");
        final Livre livre = es.saveLivre("ded", "moncif", 2009, "action", true, "por", 202);
        final Cd cd = es.saveCd("Mine", "parobol", 2005, "Action", true, 20);
        final Emprunt emprunt;
        es.createEmprunt(client, livre);

        emprunt = es.createEmprunt(client.getId(), livre.getId());
//
//        System.out.println(clientRepository.findClientByNom("mehdi"));
//
//        System.out.println(cs.getDocumentByTitre("d"));
//
//        es.retourDocument(emprunt);

        System.out.println(clientRepository.findAll());
        System.out.println( es.findAllClient());
        System.out.println(es.findAllDocument());
    }
}
