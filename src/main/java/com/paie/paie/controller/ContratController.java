package com.paie.paie.controller;

import com.paie.paie.dto.ContratRequestDto;
import com.paie.paie.dto.ContratResponseDto;
import com.paie.paie.service.ContratService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST exposant les endpoints des Contrats.
 */
@RestController
@RequestMapping("/contrats")
public class ContratController {
    private final ContratService contratService;

    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }

    /**
     * Retourne la liste complète des entités Contrat.
     *
     * @return La liste des ContratResponseDto
     */
    @GetMapping
    public List<ContratResponseDto> getAllContrats() {
        return contratService.getAllContrats();
    }

    /**
     * Recherche l'entité Contrat par son identifiant unique.
     *
     * @param id L'identifiant de l'entité Contrat recherchée
     * @return L'objet ContratResponseDto correspondant
     * @throws RuntimeException Si l'entité Contrat n'existe pas
     */
    @GetMapping("/{id}")
    public ContratResponseDto getContratById(@PathVariable Long id) {
        return contratService.getContratById(id);
    }

    /**
     * Crée une entité Contrat à partir des données fournies.
     *
     * @param contratRequest Les données de la requête (ContratRequestDto)
     * @return L'objet ContratResponseDto correspondant
     */
    @PostMapping
    public ContratResponseDto createContrat(@RequestBody ContratRequestDto contratRequest) {
        return contratService.createContrat(contratRequest);
    }

    /**
     * Met à jour l'entité Contrat existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Contrat à modifier
     * @param contratRequest Les données de la requête (ContratRequestDto)
     * @return L'objet ContratResponseDto correspondant
     * @throws RuntimeException Si l'entité Contrat n'existe pas
     */
    @PutMapping("/{id}")
    public ContratResponseDto updateContratById(@PathVariable Long id, @RequestBody ContratRequestDto contratRequest) {
        return contratService.updateContratById(id, contratRequest);
    }

    /**
     * Supprime l'entité Contrat par son identifiant.
     *
     * @param id L'identifiant de l'entité Contrat recherchée
     * @return L'objet ContratResponseDto correspondant
     * @throws RuntimeException Si l'entité Contrat n'existe pas
     */
    @DeleteMapping("/{id}")
    public ContratResponseDto deleteContratById(@PathVariable Long id) {
        return contratService.deleteContratById(id);
    }
}
