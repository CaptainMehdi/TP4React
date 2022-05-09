package com.example.tp3.repository;

import com.example.tp3.model.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
}
