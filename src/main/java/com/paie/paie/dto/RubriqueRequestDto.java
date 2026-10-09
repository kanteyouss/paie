package com.paie.paie.dto;

import java.math.BigDecimal;

/**
 * DTO de requête pour Rubrique.
 */
public class RubriqueRequestDto implements RequestDto {
    private Long id;
    private String code;
    private String libelle;
    private String type;
    private BigDecimal taux;
    private String formule;
    private BigDecimal montantCalcule;
    private Long bulletinId;
    private Long typeRubriqueId;

    public RubriqueRequestDto() {
    }

    public RubriqueRequestDto(Long id, String code, String libelle, String type, BigDecimal taux, String formule, BigDecimal montantCalcule, Long bulletinId, Long typeRubriqueId) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
        this.type = type;
        this.taux = taux;
        this.formule = formule;
        this.montantCalcule = montantCalcule;
        this.bulletinId = bulletinId;
        this.typeRubriqueId = typeRubriqueId;
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

    public Long getBulletinId() {
        return bulletinId;
    }

    public void setBulletinId(Long bulletinId) {
        this.bulletinId = bulletinId;
    }

    public Long getTypeRubriqueId() {
        return typeRubriqueId;
    }

    public void setTypeRubriqueId(Long typeRubriqueId) {
        this.typeRubriqueId = typeRubriqueId;
    }
}
