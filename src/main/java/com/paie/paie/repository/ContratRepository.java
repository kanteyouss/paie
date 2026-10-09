package com.paie.paie.repository;

import com.paie.paie.entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité Contrat.
 */
@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {
}
