package com.paie.paie.repository;

import com.paie.paie.entity.TypeAbsence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité TypeAbsence.
 */
@Repository
public interface TypeAbsenceRepository extends JpaRepository<TypeAbsence, Long> {
}
