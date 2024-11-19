package com.example.demo.repository;

import com.example.demo.model.Arbre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArbreRepository extends JpaRepository<Arbre, UUID> {
}
