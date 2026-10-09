package com.paie.paie.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Représente l'entité Variable (`variable`).
 */
@Entity
@Table(name = "variable")
public class Variable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_saisie", nullable = false)
    private LocalDate dateSaisie;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valeur;

    @ManyToOne
    @JoinColumn(name = "contrat_id", nullable = false)
    private Contrat contrat;

    @ManyToOne
    @JoinColumn(name = "type_variable_id", nullable = false)
    private TypeVariable typeVariable;

    public Variable() {
    }

    public Variable(Long id, LocalDate dateSaisie, BigDecimal valeur, Contrat contrat, TypeVariable typeVariable) {
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

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public TypeVariable getTypeVariable() {
        return typeVariable;
    }

    public void setTypeVariable(TypeVariable typeVariable) {
        this.typeVariable = typeVariable;
    }
}
