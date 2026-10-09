package com.paie.paie.repository;

import com.paie.paie.entity.Rubrique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité Rubrique.
 */
@Repository
public interface RubriqueRepository extends JpaRepository<Rubrique, Long> {
}
