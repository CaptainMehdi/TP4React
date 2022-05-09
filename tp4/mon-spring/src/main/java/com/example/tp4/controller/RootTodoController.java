package com.example.tp4.controller;

import com.example.tp4.model.personne.Client;
import com.example.tp4.model.personne.Employe;
import com.example.tp4.service.ClientService;
import com.example.tp4.service.EmployeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class RootTodoController {
    Logger logger = LoggerFactory.getLogger(RootTodoController.class);

    private final EmployeService employeService;

    public RootTodoController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping("/todos")
    @CrossOrigin(origins = "http://localhost:3001")
    public List<Client> getAllCLients(){
        logger.info("getAllClients");
        return employeService.findAllClient();
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3001")
    public ResponseEntity<Client> createClient(@RequestBody Client newClient){
        logger.info("post - createClient "+ newClient);
        return employeService.saveClient(newClient)
                .map(client -> ResponseEntity.status(HttpStatus.CREATED).body(client))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }


}