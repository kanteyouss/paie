package com.paie.paie.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Représente l'entité Regularisation (`regularisation`).
 */
@Entity
@Table(name = "regularisation")
public class Regularisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String motif;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montant;

    @ManyToOne
    @JoinColumn(name = "bulletin_id", nullable = false)
    private Bulletin bulletin;

    public Regularisation() {
    }

    public Regularisation(Long id, String motif, BigDecimal montant, Bulletin bulletin) {
        this.id = id;
        this.motif = motif;
        this.montant = montant;
        this.bulletin = bulletin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Bulletin getBulletin() {
        return bulletin;
    }

    public void setBulletin(Bulletin bulletin) {
        this.bulletin = bulletin;
    }
}
