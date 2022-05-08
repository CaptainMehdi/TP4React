package com.example.tp3.repository;

import com.example.tp3.model.document.Document;
import com.example.tp3.model.document.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Long> {

}
