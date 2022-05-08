package com.example.tp4.repository;

import com.example.tp4.model.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
}
