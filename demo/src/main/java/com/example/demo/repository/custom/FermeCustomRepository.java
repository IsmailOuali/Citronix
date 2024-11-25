package com.example.demo.repository.custom;

import com.example.demo.model.Ferme;
import com.example.demo.DTO.Ferme.FermeSearchCriteria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FermeCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Ferme> searchFermes(FermeSearchCriteria criteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ferme> query = cb.createQuery(Ferme.class);
        Root<Ferme> ferme = query.from(Ferme.class);

        List<Predicate> predicates = new ArrayList<>();

        // Filter by name
        if (criteria.getNom() != null && !criteria.getNom().isEmpty()) {
            predicates.add(cb.like(cb.lower(ferme.get("nom")), "%" + criteria.getNom().toLowerCase() + "%"));
        }

        // Filter by location
        if (criteria.getLocalisation() != null && !criteria.getLocalisation().isEmpty()) {
            predicates.add(cb.like(cb.lower(ferme.get("localisation")), "%" + criteria.getLocalisation().toLowerCase() + "%"));
        }

        // Filter by minimum area
        if (criteria.getMinSuperficie() != null) {
            predicates.add(cb.greaterThanOrEqualTo(ferme.get("superficie"), criteria.getMinSuperficie()));
        }

        // Filter by maximum area
        if (criteria.getMaxSuperficie() != null) {
            predicates.add(cb.lessThanOrEqualTo(ferme.get("superficie"), criteria.getMaxSuperficie()));
        }

        // Combine all predicates
        query.where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }
}