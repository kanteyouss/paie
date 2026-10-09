package com.paie.paie.dto;

import java.time.LocalDate;

/**
 * DTO de réponse pour Absence.
 */
public class AbsenceResponseDto {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String motif;
    private ContratResponseDto contrat;
    private TypeAbsenceResponseDto typeAbsence;

    public AbsenceResponseDto() {
    }

    public AbsenceResponseDto(Long id, LocalDate dateDebut, LocalDate dateFin, String motif, ContratResponseDto contrat, TypeAbsenceResponseDto typeAbsence) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.motif = motif;
        this.contrat = contrat;
        this.typeAbsence = typeAbsence;
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

    public ContratResponseDto getContrat() {
        return contrat;
    }

    public void setContrat(ContratResponseDto contrat) {
        this.contrat = contrat;
    }

    public TypeAbsenceResponseDto getTypeAbsence() {
        return typeAbsence;
    }

    public void setTypeAbsence(TypeAbsenceResponseDto typeAbsence) {
        this.typeAbsence = typeAbsence;
    }
}
