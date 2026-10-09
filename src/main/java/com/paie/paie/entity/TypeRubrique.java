package com.paie.paie.entity;

import jakarta.persistence.*;

/**
 * Représente l'entité TypeRubrique (`type_rubrique`).
 */
@Entity
@Table(name = "type_rubrique")
public class TypeRubrique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String libelle;

    public TypeRubrique() {
    }

    public TypeRubrique(Long id, String libelle) {
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
