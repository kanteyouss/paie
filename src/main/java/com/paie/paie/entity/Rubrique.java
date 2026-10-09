package com.paie.paie.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Représente l'entité Rubrique (`rubrique`).
 */
@Entity
@Table(name = "rubrique")
public class Rubrique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String code;

    @Column(length = 100, nullable = false)
    private String libelle;

    @Column(length = 50)
    private String type;

    @Column(precision = 5, scale = 2)
    private BigDecimal taux;

    @Column(columnDefinition = "TEXT")
    private String formule;

    @Column(name = "montant_calcule", precision = 10, scale = 2)
    private BigDecimal montantCalcule;

    @ManyToOne
    @JoinColumn(name = "bulletin_id", nullable = false)
    private Bulletin bulletin;

    @ManyToOne
    @JoinColumn(name = "type_rubrique_id", nullable = false)
    private TypeRubrique typeRubrique;

    public Rubrique() {
    }

    public Rubrique(Long id, String code, String libelle, String type, BigDecimal taux, String formule, BigDecimal montantCalcule, Bulletin bulletin, TypeRubrique typeRubrique) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
        this.type = type;
        this.taux = taux;
        this.formule = formule;
        this.montantCalcule = montantCalcule;
        this.bulletin = bulletin;
        this.typeRubrique = typeRubrique;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getTaux() {
        return taux;
    }

    public void setTaux(BigDecimal taux) {
        this.taux = taux;
    }

    public String getFormule() {
        return formule;
    }

    public void setFormule(String formule) {
        this.formule = formule;
    }

    public BigDecimal getMontantCalcule() {
        return montantCalcule;
    }

    public void setMontantCalcule(BigDecimal montantCalcule) {
        this.montantCalcule = montantCalcule;
    }

    public Bulletin getBulletin() {
        return bulletin;
    }

    public void setBulletin(Bulletin bulletin) {
        this.bulletin = bulletin;
    }

    public TypeRubrique getTypeRubrique() {
        return typeRubrique;
    }

    public void setTypeRubrique(TypeRubrique typeRubrique) {
        this.typeRubrique = typeRubrique;
    }
}
