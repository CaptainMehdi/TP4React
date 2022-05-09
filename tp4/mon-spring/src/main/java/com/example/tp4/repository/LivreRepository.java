package com.example.tp4.repository;

import com.example.tp4.model.document.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, Long> {

}
