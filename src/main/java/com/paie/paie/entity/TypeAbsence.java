package com.paie.paie.entity;

import jakarta.persistence.*;

/**
 * Représente l'entité TypeAbsence (`type_absence`).
 */
@Entity
@Table(name = "type_absence")
public class TypeAbsence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String libelle;

    public TypeAbsence() {
    }

    public TypeAbsence(Long id, String libelle) {
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
