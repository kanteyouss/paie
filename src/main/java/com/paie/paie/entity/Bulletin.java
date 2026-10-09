package com.paie.paie.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Représente l'entité Bulletin (`bulletin`).
 */
@Entity
@Table(name = "bulletin")
public class Bulletin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "periode_mois", length = 50, nullable = false)
    private String periodeMois;

    @Column(name = "date_emission", nullable = false)
    private LocalDate dateEmission;

    @Column(precision = 10, scale = 2)
    private BigDecimal brut;

    @Column(precision = 10, scale = 2)
    private BigDecimal net;

    @ManyToOne
    @JoinColumn(name = "contrat_id", nullable = false)
    private Contrat contrat;

    public Bulletin() {
    }

    public Bulletin(Long id, String periodeMois, LocalDate dateEmission, BigDecimal brut, BigDecimal net, Contrat contrat) {
        this.id = id;
        this.periodeMois = periodeMois;
        this.dateEmission = dateEmission;
        this.brut = brut;
        this.net = net;
        this.contrat = contrat;
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

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }
}
