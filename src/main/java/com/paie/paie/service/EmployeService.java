package com.paie.paie.service;

import com.paie.paie.dto.EmployeRequestDto;
import com.paie.paie.dto.EmployeResponseDto;
import com.paie.paie.entity.Employe;
import com.paie.paie.repository.EmployeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service métier gérant les Employes.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class EmployeService {
    private final EmployeRepository employeRepository;

    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    /**
     * Construit une entité Employe à partir des données de la requête.
     *
     * @param employeRequest Les données de la requête (EmployeRequestDto)
     * @return L'entité Employe construite
     */
    public Employe toEntity(EmployeRequestDto employeRequest) {
        Employe employe = new Employe();
        employe.setNom(employeRequest.getNom());
        employe.setPrenom(employeRequest.getPrenom());
        employe.setMatricule(employeRequest.getMatricule());
        employe.setDateEmbauche(employeRequest.getDateEmbauche());
        employe.setService(employeRequest.getService());
        return employe;
    }

    /**
     * Convertit une entité Employe en DTO de réponse.
     *
     * @param employe L'entité Employe à convertir
     * @return L'objet EmployeResponseDto correspondant
     */
    public EmployeResponseDto toDto(Employe employe) {
        EmployeResponseDto dto = new EmployeResponseDto();
        dto.setId(employe.getId());
        dto.setNom(employe.getNom());
        dto.setPrenom(employe.getPrenom());
        dto.setMatricule(employe.getMatricule());
        dto.setDateEmbauche(employe.getDateEmbauche());
        dto.setService(employe.getService());
        return dto;
    }

    /**
     * Retourne la liste complète des entités Employe.
     *
     * @return La liste des EmployeResponseDto
     */
    public List<EmployeResponseDto> getAllEmployes() {
        return employeRepository.findAll().stream().map(this::toDto).toList();
    }

    /**
     * Recherche l'entité Employe par son identifiant unique.
     *
     * @param id L'identifiant de l'entité Employe recherchée
     * @return L'objet EmployeResponseDto correspondant
     * @throws RuntimeException Si l'entité Employe n'existe pas
     */
    public EmployeResponseDto getEmployeById(Long id) {
        Employe employe = employeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employe non trouvé"));
        return toDto(employe);
    }

    /**
     * Crée une entité Employe à partir des données fournies.
     *
     * @param employeRequest Les données de la requête (EmployeRequestDto)
     * @return L'objet EmployeResponseDto correspondant
     */
    public EmployeResponseDto createEmploye(EmployeRequestDto employeRequest) {
        Employe employe = toEntity(employeRequest);
        return toDto(employeRepository.save(employe));
    }

    /**
     * Met à jour l'entité Employe existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Employe à modifier
     * @param employeRequest Les données de la requête (EmployeRequestDto)
     * @return L'objet EmployeResponseDto correspondant
     * @throws RuntimeException Si l'entité Employe n'existe pas
     */
    public EmployeResponseDto updateEmployeById(Long id, EmployeRequestDto employeRequest) {
        Employe employe = employeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employe non trouvé"));
        employe.setNom(employeRequest.getNom());
        employe.setPrenom(employeRequest.getPrenom());
        employe.setMatricule(employeRequest.getMatricule());
        employe.setDateEmbauche(employeRequest.getDateEmbauche());
        employe.setService(employeRequest.getService());
        return toDto(employeRepository.save(employe));
    }

    /**
     * Supprime l'entité Employe par son identifiant.
     *
     * @param id L'identifiant de l'entité Employe recherchée
     * @return L'objet EmployeResponseDto correspondant
     * @throws RuntimeException Si l'entité Employe n'existe pas
     */
    public EmployeResponseDto deleteEmployeById(Long id) {
        Employe employe = employeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employe non trouvé"));
        employeRepository.deleteById(id);
        return toDto(employe);
    }
}