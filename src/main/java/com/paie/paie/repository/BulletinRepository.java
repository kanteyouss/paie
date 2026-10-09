package com.paie.paie.repository;

import com.paie.paie.entity.Bulletin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité Bulletin.
 */
@Repository
public interface BulletinRepository extends JpaRepository<Bulletin, Long> {
}
