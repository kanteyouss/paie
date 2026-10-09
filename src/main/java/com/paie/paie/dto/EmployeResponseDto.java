package com.paie.paie.dto;

import java.time.LocalDate;

/**
 * DTO de réponse pour Employe.
 */
public class EmployeResponseDto implements ResponseDto {
    private Long id;
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private String service;

    public EmployeResponseDto() {
    }

    public EmployeResponseDto(Long id, String nom, String prenom, String matricule, LocalDate dateEmbauche, String service) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
