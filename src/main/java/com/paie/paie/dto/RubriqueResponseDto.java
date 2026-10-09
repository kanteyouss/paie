package com.paie.paie.dto;

import java.math.BigDecimal;

/**
 * DTO de réponse pour Rubrique.
 */
public class RubriqueResponseDto implements ResponseDto {
    private Long id;
    private String code;
    private String libelle;
    private String type;
    private BigDecimal taux;
    private String formule;
    private BigDecimal montantCalcule;
    private BulletinResponseDto bulletin;
    private TypeRubriqueResponseDto typeRubrique;

    public RubriqueResponseDto() {
    }

    public RubriqueResponseDto(Long id, String code, String libelle, String type, BigDecimal taux, String formule, BigDecimal montantCalcule, BulletinResponseDto bulletin, TypeRubriqueResponseDto typeRubrique) {
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

    public BulletinResponseDto getBulletin() {
        return bulletin;
    }

    public void setBulletin(BulletinResponseDto bulletin) {
        this.bulletin = bulletin;
    }

    public TypeRubriqueResponseDto getTypeRubrique() {
        return typeRubrique;
    }

    public void setTypeRubrique(TypeRubriqueResponseDto typeRubrique) {
        this.typeRubrique = typeRubrique;
    }
}
