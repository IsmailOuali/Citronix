package com.example.demo.repository;

import com.example.demo.model.DetailRecolte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRecolteRepository extends JpaRepository<DetailRecolte, Long> {
}
