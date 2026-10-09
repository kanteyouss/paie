package com.paie.paie.repository;

import com.paie.paie.entity.TypeVariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité TypeVariable.
 */
@Repository
public interface TypeVariableRepository extends JpaRepository<TypeVariable, Long> {
}
