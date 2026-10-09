package com.paie.paie.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO de réponse pour Variable.
 */
public class VariableResponseDto {
    private Long id;
    private LocalDate dateSaisie;
    private BigDecimal valeur;
    private ContratResponseDto contrat;
    private TypeVariableResponseDto typeVariable;

    public VariableResponseDto() {
    }

    public VariableResponseDto(Long id, LocalDate dateSaisie, BigDecimal valeur, ContratResponseDto contrat, TypeVariableResponseDto typeVariable) {
        this.id = id;
        this.dateSaisie = dateSaisie;
        this.valeur = valeur;
        this.contrat = contrat;
        this.typeVariable = typeVariable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateSaisie() {
        return dateSaisie;
    }

    public void setDateSaisie(LocalDate dateSaisie) {
        this.dateSaisie = dateSaisie;
    }

    public BigDecimal getValeur() {
        return valeur;
    }

    public void setValeur(BigDecimal valeur) {
        this.valeur = valeur;
    }

    public ContratResponseDto getContrat() {
        return contrat;
    }

    public void setContrat(ContratResponseDto contrat) {
        this.contrat = contrat;
    }

    public TypeVariableResponseDto getTypeVariable() {
        return typeVariable;
    }

    public void setTypeVariable(TypeVariableResponseDto typeVariable) {
        this.typeVariable = typeVariable;
    }
}
