package com.example.demo.repository;

import com.example.demo.model.Champ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChampRepository extends JpaRepository<Champ, UUID> {
}
