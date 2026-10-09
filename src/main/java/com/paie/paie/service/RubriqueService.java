package com.paie.paie.service;

import com.paie.paie.dto.RequestDto;
import com.paie.paie.dto.ResponseDto;
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


/**
 * Service métier gérant les Rubriques.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class RubriqueService extends AbstractCrudService {
    private final RubriqueRepository rubriqueRepository;
    private final BulletinRepository bulletinRepository;
    private final BulletinService bulletinService;
    private final TypeRubriqueRepository typeRubriqueRepository;
    private final TypeRubriqueService typeRubriqueService;

    public RubriqueService(RubriqueRepository rubriqueRepository, BulletinRepository bulletinRepository, BulletinService bulletinService, TypeRubriqueRepository typeRubriqueRepository, TypeRubriqueService typeRubriqueService) {
        super(rubriqueRepository);
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
    @Override
    public ResponseDto toDto(Object entity) {
        Rubrique rubrique = (Rubrique) entity;
        RubriqueResponseDto dto = new RubriqueResponseDto();
        dto.setId(rubrique.getId());
        dto.setCode(rubrique.getCode());
        dto.setLibelle(rubrique.getLibelle());
        dto.setType(rubrique.getType());
        dto.setTaux(rubrique.getTaux());
        dto.setFormule(rubrique.getFormule());
        dto.setMontantCalcule(rubrique.getMontantCalcule());
        if (rubrique.getBulletin() != null) {
            dto.setBulletin((BulletinResponseDto) bulletinService.toDto(rubrique.getBulletin()));
        }
        if (rubrique.getTypeRubrique() != null) {
            dto.setTypeRubrique(typeRubriqueService.toDto(rubrique.getTypeRubrique()));
        }
        return dto;
    }



    /**
     * Crée une entité Rubrique à partir des données fournies.
     *
     * @param rubriqueRequest Les données de la requête (RubriqueRequestDto)
     * @return L'objet RubriqueResponseDto correspondant
     */
    @Override
    public ResponseDto create(RequestDto request) {
        RubriqueRequestDto rubriqueRequest = (RubriqueRequestDto) request;
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
    @Override
    public ResponseDto update(Long id, RequestDto request) {
        RubriqueRequestDto rubriqueRequest = (RubriqueRequestDto) request;
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

}