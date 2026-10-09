package com.paie.paie.repository;

import com.paie.paie.entity.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité Conge.
 */
@Repository
public interface CongeRepository extends JpaRepository<Conge, Long> {
}
