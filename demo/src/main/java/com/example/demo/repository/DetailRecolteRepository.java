package com.example.demo.repository;

import com.example.demo.model.DetailRecolte;
import com.example.demo.model.DetailRecolteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DetailRecolteRepository extends JpaRepository<DetailRecolte, DetailRecolteId> {
    List<DetailRecolte> findByArbreId(UUID arbreId);

    @Query("SELECT SUM(d.quantiteRecoltee) FROM DetailRecolte d WHERE d.recolte.id = :recolteId")
    double sumQuantiteByRecolteId(UUID recolteId);

}
