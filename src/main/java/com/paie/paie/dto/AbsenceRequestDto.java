package com.paie.paie.dto;

import java.time.LocalDate;

/**
 * DTO de requête pour Absence.
 */
public class AbsenceRequestDto implements RequestDto {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String motif;
    private Long contratId;
    private Long typeAbsenceId;

    public AbsenceRequestDto() {
    }

    public AbsenceRequestDto(Long id, LocalDate dateDebut, LocalDate dateFin, String motif, Long contratId, Long typeAbsenceId) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.motif = motif;
        this.contratId = contratId;
        this.typeAbsenceId = typeAbsenceId;
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

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Long getContratId() {
        return contratId;
    }

    public void setContratId(Long contratId) {
        this.contratId = contratId;
    }

    public Long getTypeAbsenceId() {
        return typeAbsenceId;
    }

    public void setTypeAbsenceId(Long typeAbsenceId) {
        this.typeAbsenceId = typeAbsenceId;
    }
}
