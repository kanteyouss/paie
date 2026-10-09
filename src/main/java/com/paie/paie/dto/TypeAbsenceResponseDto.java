package com.paie.paie.dto;

/**
 * DTO de réponse pour TypeAbsence.
 */
public class TypeAbsenceResponseDto {
    private Long id;
    private String libelle;

    public TypeAbsenceResponseDto() {
    }

    public TypeAbsenceResponseDto(Long id, String libelle) {
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
