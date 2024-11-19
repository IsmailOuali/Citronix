package com.example.demo.repository;

import com.example.demo.model.Ferme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FermeRepository extends JpaRepository<Ferme, Long> {
}
