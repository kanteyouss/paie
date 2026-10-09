package com.paie.paie.repository;

import com.paie.paie.entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité Absence.
 */
@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {
}
