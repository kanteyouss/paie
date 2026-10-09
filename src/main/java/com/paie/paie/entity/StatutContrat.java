package com.paie.paie.entity;

import jakarta.persistence.*;

/**
 * Représente l'entité StatutContrat (`statut_contrat`).
 */
@Entity
@Table(name = "statut_contrat")
public class StatutContrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String libelle;

    public StatutContrat() {
    }

    public StatutContrat(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
