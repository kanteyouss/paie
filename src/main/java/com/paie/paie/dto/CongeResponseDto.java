package com.paie.paie.dto;

import java.math.BigDecimal;

/**
 * DTO de réponse pour Conge.
 */
public class CongeResponseDto {
    private Long id;
    private String periode;
    private BigDecimal soldeJours;
    private ContratResponseDto contrat;

    public CongeResponseDto() {
    }

    public CongeResponseDto(Long id, String periode, BigDecimal soldeJours, ContratResponseDto contrat) {
        this.id = id;
        this.periode = periode;
        this.soldeJours = soldeJours;
        this.contrat = contrat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public BigDecimal getSoldeJours() {
        return soldeJours;
    }

    public void setSoldeJours(BigDecimal soldeJours) {
        this.soldeJours = soldeJours;
    }

    public ContratResponseDto getContrat() {
        return contrat;
    }

    public void setContrat(ContratResponseDto contrat) {
        this.contrat = contrat;
    }
}
