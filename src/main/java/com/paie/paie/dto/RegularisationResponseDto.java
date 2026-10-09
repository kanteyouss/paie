package com.paie.paie.dto;

import java.math.BigDecimal;

/**
 * DTO de réponse pour Regularisation.
 */
public class RegularisationResponseDto {
    private Long id;
    private String motif;
    private BigDecimal montant;
    private BulletinResponseDto bulletin;

    public RegularisationResponseDto() {
    }

    public RegularisationResponseDto(Long id, String motif, BigDecimal montant, BulletinResponseDto bulletin) {
        this.id = id;
        this.motif = motif;
        this.montant = montant;
        this.bulletin = bulletin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public BulletinResponseDto getBulletin() {
        return bulletin;
    }

    public void setBulletin(BulletinResponseDto bulletin) {
        this.bulletin = bulletin;
    }
}
