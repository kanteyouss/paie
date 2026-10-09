package com.paie.paie.controller;

import com.paie.paie.dto.AbsenceRequestDto;
import com.paie.paie.dto.AbsenceResponseDto;
import com.paie.paie.service.AbsenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST exposant les endpoints des Absences.
 */
@RestController
@RequestMapping("/absences")
public class AbsenceController {
    private final AbsenceService absenceService;

    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    /**
     * Retourne la liste complète des entités Absence.
     *
     * @return La liste des AbsenceResponseDto
     */
    @GetMapping
    public List<AbsenceResponseDto> getAllAbsences() {
        return absenceService.getAllAbsences();
    }

    /**
     * Recherche l'entité Absence par son identifiant unique.
     *
     * @param id L'identifiant de l'entité Absence recherchée
     * @return L'objet AbsenceResponseDto correspondant
     * @throws RuntimeException Si l'entité Absence n'existe pas
     */
    @GetMapping("/{id}")
    public AbsenceResponseDto getAbsenceById(@PathVariable Long id) {
        return absenceService.getAbsenceById(id);
    }

    /**
     * Crée une entité Absence à partir des données fournies.
     *
     * @param absenceRequest Les données de la requête (AbsenceRequestDto)
     * @return L'objet AbsenceResponseDto correspondant
     */
    @PostMapping
    public AbsenceResponseDto createAbsence(@RequestBody AbsenceRequestDto absenceRequest) {
        return absenceService.createAbsence(absenceRequest);
    }

    /**
     * Met à jour l'entité Absence existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Absence à modifier
     * @param absenceRequest Les données de la requête (AbsenceRequestDto)
     * @return L'objet AbsenceResponseDto correspondant
     * @throws RuntimeException Si l'entité Absence n'existe pas
     */
    @PutMapping("/{id}")
    public AbsenceResponseDto updateAbsenceById(@PathVariable Long id, @RequestBody AbsenceRequestDto absenceRequest) {
        return absenceService.updateAbsenceById(id, absenceRequest);
    }

    /**
     * Supprime l'entité Absence par son identifiant.
     *
     * @param id L'identifiant de l'entité Absence recherchée
     * @return L'objet AbsenceResponseDto correspondant
     * @throws RuntimeException Si l'entité Absence n'existe pas
     */
    @DeleteMapping("/{id}")
    public AbsenceResponseDto deleteAbsenceById(@PathVariable Long id) {
        return absenceService.deleteAbsenceById(id);
    }
}
