package com.example.tp3.repository;

import com.example.tp3.model.document.Document;
import com.example.tp3.model.document.Dvd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DvdRepository extends JpaRepository<Dvd, Long> {
}
