package com.example.demo.repository;

import com.example.demo.model.DetailRecolte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DetailRecolteRepository extends JpaRepository<DetailRecolte, UUID> {
}
