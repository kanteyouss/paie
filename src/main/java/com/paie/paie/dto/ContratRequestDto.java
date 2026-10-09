package com.paie.paie.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO de requête pour Contrat.
 */
public class ContratRequestDto {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String poste;
    private BigDecimal salaireBase;
    private String tempsTravail;
    private LocalDateTime dateCreation;
    private String type;
    private Long employeId;
    private Long statutContratId;

    public ContratRequestDto() {
    }

    public ContratRequestDto(Long id, LocalDate dateDebut, LocalDate dateFin, String poste, BigDecimal salaireBase, String tempsTravail, LocalDateTime dateCreation, String type, Long employeId, Long statutContratId) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.poste = poste;
        this.salaireBase = salaireBase;
        this.tempsTravail = tempsTravail;
        this.dateCreation = dateCreation;
        this.type = type;
        this.employeId = employeId;
        this.statutContratId = statutContratId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public BigDecimal getSalaireBase() {
        return salaireBase;
    }

    public void setSalaireBase(BigDecimal salaireBase) {
        this.salaireBase = salaireBase;
    }

    public String getTempsTravail() {
        return tempsTravail;
    }

    public void setTempsTravail(String tempsTravail) {
        this.tempsTravail = tempsTravail;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getEmployeId() {
        return employeId;
    }

    public void setEmployeId(Long employeId) {
        this.employeId = employeId;
    }

    public Long getStatutContratId() {
        return statutContratId;
    }

    public void setStatutContratId(Long statutContratId) {
        this.statutContratId = statutContratId;
    }
}
