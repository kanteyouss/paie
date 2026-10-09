package com.paie.paie.repository;

import com.paie.paie.entity.Variable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité Variable.
 */
@Repository
public interface VariableRepository extends JpaRepository<Variable, Long> {
}
