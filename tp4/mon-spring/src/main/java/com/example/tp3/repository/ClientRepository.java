package com.example.tp3.repository;

import com.example.tp3.model.personne.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientByNom(String nom);

    @Query("select c.nom from Client c where c.nom like %:clientNom%")
    List<Object[]> findByAsArray(@Param("clientNom") String text);
}
