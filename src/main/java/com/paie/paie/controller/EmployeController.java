package com.paie.paie.controller;

import com.paie.paie.dto.EmployeRequestDto;
import com.paie.paie.dto.EmployeResponseDto;
import com.paie.paie.service.EmployeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST exposant les endpoints des Employes.
 */
@RestController
@RequestMapping("/employes")
public class EmployeController {
    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    /**
     * Retourne la liste complète des entités Employe.
     *
     * @return La liste des EmployeResponseDto
     */
    @GetMapping
    public List<EmployeResponseDto> getAllEmployes() {
        return employeService.getAllEmployes();
    }

    /**
     * Recherche l'entité Employe par son identifiant unique.
     *
     * @param id L'identifiant de l'entité Employe recherchée
     * @return L'objet EmployeResponseDto correspondant
     * @throws RuntimeException Si l'entité Employe n'existe pas
     */
    @GetMapping("/{id}")
    public EmployeResponseDto getEmployeById(@PathVariable Long id) {
        return employeService.getEmployeById(id);
    }

    /**
     * Crée une entité Employe à partir des données fournies.
     *
     * @param employeRequest Les données de la requête (EmployeRequestDto)
     * @return L'objet EmployeResponseDto correspondant
     */
    @PostMapping
    public EmployeResponseDto createEmploye(@RequestBody EmployeRequestDto employeRequest) {
        return employeService.createEmploye(employeRequest);
    }

    /**
     * Met à jour l'entité Employe existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Employe à modifier
     * @param employeRequest Les données de la requête (EmployeRequestDto)
     * @return L'objet EmployeResponseDto correspondant
     * @throws RuntimeException Si l'entité Employe n'existe pas
     */
    @PutMapping("/{id}")
    public EmployeResponseDto updateEmployeById(@PathVariable Long id, @RequestBody EmployeRequestDto employeRequest) {
        return employeService.updateEmployeById(id, employeRequest);
    }

    /**
     * Supprime l'entité Employe par son identifiant.
     *
     * @param id L'identifiant de l'entité Employe recherchée
     * @return L'objet EmployeResponseDto correspondant
     * @throws RuntimeException Si l'entité Employe n'existe pas
     */
    @DeleteMapping("/{id}")
    public EmployeResponseDto deleteEmployeById(@PathVariable Long id) {
        return employeService.deleteEmployeById(id);
    }
}
