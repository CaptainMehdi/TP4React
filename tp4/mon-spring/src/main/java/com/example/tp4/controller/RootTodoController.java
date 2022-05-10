package com.example.tp4.controller;

import com.example.tp4.DTO.ClientDTO;
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

    @GetMapping("/getAll")
    public List<ClientDTO> getAllCLients(){
        return employeService.findAllClient();
    }

    @PostMapping("/add")
    public ClientDTO createClient(@RequestBody Client newClient){
        logger.info("post - createClient "+ newClient);
        return employeService.saveClient(newClient);
    }


}
