package com.paie.paie.repository;

import com.paie.paie.entity.StatutContrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité StatutContrat.
 */
@Repository
public interface StatutContratRepository extends JpaRepository<StatutContrat, Long> {
}
