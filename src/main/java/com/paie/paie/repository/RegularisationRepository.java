package com.paie.paie.repository;

import com.paie.paie.entity.Regularisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité Regularisation.
 */
@Repository
public interface RegularisationRepository extends JpaRepository<Regularisation, Long> {
}
