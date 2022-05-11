package com.example.tp4.controller;

import com.example.tp4.DTO.*;
import com.example.tp4.model.document.Cd;
import com.example.tp4.model.document.Dvd;
import com.example.tp4.model.document.Livre;
import com.example.tp4.model.personne.Client;
import com.example.tp4.model.personne.Employe;
import com.example.tp4.service.ClientService;
import com.example.tp4.service.EmployeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@CrossOrigin
public class RootTodoController {
    Logger logger = LoggerFactory.getLogger(RootTodoController.class);

    private final EmployeService employeService;

    public RootTodoController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping("/getAllClients")
    public List<ClientDTO> getAllClients(){
        return employeService.findAllClient();
    }

    @PostMapping("/addClients")
    public ClientDTO createClient(@RequestBody Client newClient){
        logger.info("post - createClient "+ newClient);
        return employeService.saveClient(newClient);
    }
//DOCUMENT
    @GetMapping("/getAllDocument")
    public List<DocumentDTO> getAllDocument(){
    return employeService.findAllDocument();
}

    //Livre
    @GetMapping("/getAllLivres")
    public List<LivreDTO> getAllLivre(){
        return employeService.findAllLivre();
    }

    @PostMapping("/addLivres")
    public LivreDTO createLivre(@RequestBody Livre newLivre){
        logger.info("post - createLivre "+ newLivre);
        return employeService.saveLivre(newLivre);
    }


    //Cd

    @GetMapping("/getAllCd")
    public List<CdDTO> getAllCd(){
        return employeService.findAllCd();
    }

    @PostMapping("/addCd")
    public CdDTO createCd(@RequestBody Cd newCd) {
        logger.info("post - createCd " + newCd);
        return employeService.saveCd(newCd);
    }

    //DVD

    @GetMapping("/getAllDvd")
    public List<DvdDTO> getAllDvd(){
        return employeService.findAllDvd();
    }

    @PostMapping("/addDvd")
    public DvdDTO createDvd(@RequestBody Dvd newDvd) {
        logger.info("post - createDvd " + newDvd);
        return employeService.saveDvd(newDvd);
    }


}
