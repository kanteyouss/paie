package com.paie.paie.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Représente l'entité Conge (`conge`).
 */
@Entity
@Table(name = "conge")
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String periode;

    @Column(name = "solde_jours", nullable = false, precision = 5, scale = 2)
    private BigDecimal soldeJours;

    @ManyToOne
    @JoinColumn(name = "contrat_id", nullable = false)
    private Contrat contrat;

    public Conge() {
    }

    public Conge(Long id, String periode, BigDecimal soldeJours, Contrat contrat) {
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

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }
}
