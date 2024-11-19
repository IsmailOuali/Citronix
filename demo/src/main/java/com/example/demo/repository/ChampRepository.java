package com.example.demo.repository;

import com.example.demo.model.Champ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampRepository extends JpaRepository<Champ, Long> {
}
