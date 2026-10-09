package com.paie.paie.controller;

import com.paie.paie.dto.RubriqueRequestDto;
import com.paie.paie.dto.RubriqueResponseDto;
import com.paie.paie.service.RubriqueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST exposant les endpoints des Rubriques.
 */
@RestController
@RequestMapping("/rubriques")
public class RubriqueController {
    private final RubriqueService rubriqueService;

    public RubriqueController(RubriqueService rubriqueService) {
        this.rubriqueService = rubriqueService;
    }

    /**
     * Retourne la liste complète des entités Rubrique.
     *
     * @return La liste des RubriqueResponseDto
     */
    @GetMapping
    public List<RubriqueResponseDto> getAllRubriques() {
        return rubriqueService.getAllRubriques();
    }

    /**
     * Recherche l'entité Rubrique par son identifiant unique.
     *
     * @param id L'identifiant de l'entité Rubrique recherchée
     * @return L'objet RubriqueResponseDto correspondant
     * @throws RuntimeException Si l'entité Rubrique n'existe pas
     */
    @GetMapping("/{id}")
    public RubriqueResponseDto getRubriqueById(@PathVariable Long id) {
        return rubriqueService.getRubriqueById(id);
    }

    /**
     * Crée une entité Rubrique à partir des données fournies.
     *
     * @param rubriqueRequest Les données de la requête (RubriqueRequestDto)
     * @return L'objet RubriqueResponseDto correspondant
     */
    @PostMapping
    public RubriqueResponseDto createRubrique(@RequestBody RubriqueRequestDto rubriqueRequest) {
        return rubriqueService.createRubrique(rubriqueRequest);
    }

    /**
     * Met à jour l'entité Rubrique existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Rubrique à modifier
     * @param rubriqueRequest Les données de la requête (RubriqueRequestDto)
     * @return L'objet RubriqueResponseDto correspondant
     * @throws RuntimeException Si l'entité Rubrique n'existe pas
     */
    @PutMapping("/{id}")
    public RubriqueResponseDto updateRubriqueById(@PathVariable Long id, @RequestBody RubriqueRequestDto rubriqueRequest) {
        return rubriqueService.updateRubriqueById(id, rubriqueRequest);
    }

    /**
     * Supprime l'entité Rubrique par son identifiant.
     *
     * @param id L'identifiant de l'entité Rubrique recherchée
     * @return L'objet RubriqueResponseDto correspondant
     * @throws RuntimeException Si l'entité Rubrique n'existe pas
     */
    @DeleteMapping("/{id}")
    public RubriqueResponseDto deleteRubriqueById(@PathVariable Long id) {
        return rubriqueService.deleteRubriqueById(id);
    }
}
