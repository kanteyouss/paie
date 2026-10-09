package com.paie.paie.repository;

import com.paie.paie.entity.TypeRubrique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité TypeRubrique.
 */
@Repository
public interface TypeRubriqueRepository extends JpaRepository<TypeRubrique, Long> {
}
