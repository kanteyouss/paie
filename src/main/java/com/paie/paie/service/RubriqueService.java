package com.paie.paie.service;

import com.paie.paie.dto.RubriqueRequestDto;
import com.paie.paie.dto.RubriqueResponseDto;
import com.paie.paie.dto.BulletinResponseDto;
import com.paie.paie.dto.TypeRubriqueResponseDto;
import com.paie.paie.entity.Rubrique;
import com.paie.paie.entity.Bulletin;
import com.paie.paie.entity.TypeRubrique;
import com.paie.paie.repository.RubriqueRepository;
import com.paie.paie.repository.BulletinRepository;
import com.paie.paie.repository.TypeRubriqueRepository;
import com.paie.paie.service.BulletinService;
import com.paie.paie.service.TypeRubriqueService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service métier gérant les Rubriques.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class RubriqueService {
    private final RubriqueRepository rubriqueRepository;
    private final BulletinRepository bulletinRepository;
    private final BulletinService bulletinService;
    private final TypeRubriqueRepository typeRubriqueRepository;
    private final TypeRubriqueService typeRubriqueService;

    public RubriqueService(RubriqueRepository rubriqueRepository, BulletinRepository bulletinRepository, BulletinService bulletinService, TypeRubriqueRepository typeRubriqueRepository, TypeRubriqueService typeRubriqueService) {
        this.rubriqueRepository = rubriqueRepository;
        this.bulletinRepository = bulletinRepository;
        this.bulletinService = bulletinService;
        this.typeRubriqueRepository = typeRubriqueRepository;
        this.typeRubriqueService = typeRubriqueService;
    }

    /**
     * Construit une entité Rubrique à partir des données de la requête.
     *
     * @param rubriqueRequest Les données de la requête (RubriqueRequestDto)
     * @param bulletin L'entité Bulletin associée
     * @param typeRubrique L'entité TypeRubrique associée
     * @return L'entité Rubrique construite
     */
    public Rubrique toEntity(RubriqueRequestDto rubriqueRequest, Bulletin bulletin, TypeRubrique typeRubrique) {
        Rubrique rubrique = new Rubrique();
        rubrique.setCode(rubriqueRequest.getCode());
        rubrique.setLibelle(rubriqueRequest.getLibelle());
        rubrique.setType(rubriqueRequest.getType());
        rubrique.setTaux(rubriqueRequest.getTaux());
        rubrique.setFormule(rubriqueRequest.getFormule());
        rubrique.setMontantCalcule(rubriqueRequest.getMontantCalcule());
        rubrique.setBulletin(bulletin);
        rubrique.setTypeRubrique(typeRubrique);
        return rubrique;
    }

    /**
     * Convertit une entité Rubrique en DTO de réponse.
     *
     * @param rubrique L'entité Rubrique à convertir
     * @return L'objet RubriqueResponseDto correspondant
     */
    public RubriqueResponseDto toDto(Rubrique rubrique) {
        RubriqueResponseDto dto = new RubriqueResponseDto();
        dto.setId(rubrique.getId());
        dto.setCode(rubrique.getCode());
        dto.setLibelle(rubrique.getLibelle());
        dto.setType(rubrique.getType());
        dto.setTaux(rubrique.getTaux());
        dto.setFormule(rubrique.getFormule());
        dto.setMontantCalcule(rubrique.getMontantCalcule());
        if (rubrique.getBulletin() != null) {
            dto.setBulletin(bulletinService.toDto(rubrique.getBulletin()));
        }
        if (rubrique.getTypeRubrique() != null) {
            dto.setTypeRubrique(typeRubriqueService.toDto(rubrique.getTypeRubrique()));
        }
        return dto;
    }

    /**
     * Retourne la liste complète des entités Rubrique.
     *
     * @return La liste des RubriqueResponseDto
     */
    public List<RubriqueResponseDto> getAllRubriques() {
        return rubriqueRepository.findAll().stream().map(this::toDto).toList();
    }

    /**
     * Recherche l'entité Rubrique par son identifiant unique.
     *
     * @param id L'identifiant de l'entité Rubrique recherchée
     * @return L'objet RubriqueResponseDto correspondant
     * @throws RuntimeException Si l'entité Rubrique n'existe pas
     */
    public RubriqueResponseDto getRubriqueById(Long id) {
        Rubrique rubrique = rubriqueRepository.findById(id).orElseThrow(() -> new RuntimeException("Rubrique non trouvé"));
        return toDto(rubrique);
    }

    /**
     * Crée une entité Rubrique à partir des données fournies.
     *
     * @param rubriqueRequest Les données de la requête (RubriqueRequestDto)
     * @return L'objet RubriqueResponseDto correspondant
     */
    public RubriqueResponseDto createRubrique(RubriqueRequestDto rubriqueRequest) {
        Bulletin bulletin = bulletinRepository.findById(rubriqueRequest.getBulletinId()).orElseThrow(() -> new RuntimeException("Bulletin non trouvé"));
        TypeRubrique typeRubrique = typeRubriqueRepository.findById(rubriqueRequest.getTypeRubriqueId()).orElseThrow(() -> new RuntimeException("TypeRubrique non trouvé"));
        Rubrique rubrique = toEntity(rubriqueRequest, bulletin, typeRubrique);
        return toDto(rubriqueRepository.save(rubrique));
    }

    /**
     * Met à jour l'entité Rubrique existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Rubrique à modifier
     * @param rubriqueRequest Les données de la requête (RubriqueRequestDto)
     * @return L'objet RubriqueResponseDto correspondant
     * @throws RuntimeException Si l'entité Rubrique n'existe pas
     */
    public RubriqueResponseDto updateRubriqueById(Long id, RubriqueRequestDto rubriqueRequest) {
        Bulletin bulletin = bulletinRepository.findById(rubriqueRequest.getBulletinId()).orElseThrow(() -> new RuntimeException("Bulletin non trouvé"));
        TypeRubrique typeRubrique = typeRubriqueRepository.findById(rubriqueRequest.getTypeRubriqueId()).orElseThrow(() -> new RuntimeException("TypeRubrique non trouvé"));
        Rubrique rubrique = rubriqueRepository.findById(id).orElseThrow(() -> new RuntimeException("Rubrique non trouvé"));
        rubrique.setCode(rubriqueRequest.getCode());
        rubrique.setLibelle(rubriqueRequest.getLibelle());
        rubrique.setType(rubriqueRequest.getType());
        rubrique.setTaux(rubriqueRequest.getTaux());
        rubrique.setFormule(rubriqueRequest.getFormule());
        rubrique.setMontantCalcule(rubriqueRequest.getMontantCalcule());
        rubrique.setBulletin(bulletin);
        rubrique.setTypeRubrique(typeRubrique);
        return toDto(rubriqueRepository.save(rubrique));
    }

    /**
     * Supprime l'entité Rubrique par son identifiant.
     *
     * @param id L'identifiant de l'entité Rubrique recherchée
     * @return L'objet RubriqueResponseDto correspondant
     * @throws RuntimeException Si l'entité Rubrique n'existe pas
     */
    public RubriqueResponseDto deleteRubriqueById(Long id) {
        Rubrique rubrique = rubriqueRepository.findById(id).orElseThrow(() -> new RuntimeException("Rubrique non trouvé"));
        rubriqueRepository.deleteById(id);
        return toDto(rubrique);
    }
}