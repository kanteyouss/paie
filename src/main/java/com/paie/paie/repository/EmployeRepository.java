package com.paie.paie.repository;

import com.paie.paie.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité Employe.
 */
@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

    /**
     * Vérifie l'existence d'une entité dont matricule correspond.
     *
     * @param matricule Matricule (String)
     * @return Vrai si la condition est remplie, sinon faux
     */
    boolean existsByMatricule(String matricule);

    /**
     * Vérifie l'existence d'une entité dont matriculeandidnot correspond.
     *
     * @param matricule Matricule (String)
     * @param id L'identifiant de l'entité Employe recherchée
     * @return Vrai si la condition est remplie, sinon faux
     */
    boolean existsByMatriculeAndIdNot(String matricule, Long id);
}
