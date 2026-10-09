package com.paie.paie.dto;

/**
 * DTO de réponse pour TypeVariable.
 */
public class TypeVariableResponseDto {
    private Long id;
    private String libelle;

    public TypeVariableResponseDto() {
    }

    public TypeVariableResponseDto(Long id, String libelle) {
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
