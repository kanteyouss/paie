package com.paie.paie.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO de requête pour Bulletin.
 */
public class BulletinRequestDto implements RequestDto {
    private Long id;
    private String periodeMois;
    private LocalDate dateEmission;
    private BigDecimal brut;
    private BigDecimal net;
    private Long contratId;

    public BulletinRequestDto() {
    }

    public BulletinRequestDto(Long id, String periodeMois, LocalDate dateEmission, BigDecimal brut, BigDecimal net, Long contratId) {
        this.id = id;
        this.periodeMois = periodeMois;
        this.dateEmission = dateEmission;
        this.brut = brut;
        this.net = net;
        this.contratId = contratId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriodeMois() {
        return periodeMois;
    }

    public void setPeriodeMois(String periodeMois) {
        this.periodeMois = periodeMois;
    }

    public LocalDate getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(LocalDate dateEmission) {
        this.dateEmission = dateEmission;
    }

    public BigDecimal getBrut() {
        return brut;
    }

    public void setBrut(BigDecimal brut) {
        this.brut = brut;
    }

    public BigDecimal getNet() {
        return net;
    }

    public void setNet(BigDecimal net) {
        this.net = net;
    }

    public Long getContratId() {
        return contratId;
    }

    public void setContratId(Long contratId) {
        this.contratId = contratId;
    }
}
