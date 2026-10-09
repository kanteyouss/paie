package com.paie.paie.service;

import com.paie.paie.dto.RequestDto;
import com.paie.paie.dto.ResponseDto;
import com.paie.paie.dto.AbsenceRequestDto;
import com.paie.paie.dto.AbsenceResponseDto;
import com.paie.paie.dto.ContratResponseDto;
import com.paie.paie.dto.TypeAbsenceResponseDto;
import com.paie.paie.entity.Absence;
import com.paie.paie.entity.Contrat;
import com.paie.paie.entity.TypeAbsence;
import com.paie.paie.repository.AbsenceRepository;
import com.paie.paie.repository.ContratRepository;
import com.paie.paie.repository.TypeAbsenceRepository;
import com.paie.paie.service.ContratService;
import com.paie.paie.service.TypeAbsenceService;
import org.springframework.stereotype.Service;


/**
 * Service métier gérant les Absences.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class AbsenceService extends AbstractCrudService {
    private final AbsenceRepository absenceRepository;
    private final ContratRepository contratRepository;
    private final ContratService contratService;
    private final TypeAbsenceRepository typeAbsenceRepository;
    private final TypeAbsenceService typeAbsenceService;

    public AbsenceService(AbsenceRepository absenceRepository, ContratRepository contratRepository, ContratService contratService, TypeAbsenceRepository typeAbsenceRepository, TypeAbsenceService typeAbsenceService) {
        super(absenceRepository);
        this.absenceRepository = absenceRepository;
        this.contratRepository = contratRepository;
        this.contratService = contratService;
        this.typeAbsenceRepository = typeAbsenceRepository;
        this.typeAbsenceService = typeAbsenceService;
    }

    /**
     * Construit une entité Absence à partir des données de la requête.
     *
     * @param absenceRequest Les données de la requête (AbsenceRequestDto)
     * @param contrat L'entité Contrat associée
     * @param typeAbsence L'entité TypeAbsence associée
     * @return L'entité Absence construite
     */
    public Absence toEntity(AbsenceRequestDto absenceRequest, Contrat contrat, TypeAbsence typeAbsence) {
        Absence absence = new Absence();
        absence.setDateDebut(absenceRequest.getDateDebut());
        absence.setDateFin(absenceRequest.getDateFin());
        absence.setMotif(absenceRequest.getMotif());
        absence.setContrat(contrat);
        absence.setTypeAbsence(typeAbsence);
        return absence;
    }

    /**
     * Convertit une entité Absence en DTO de réponse.
     *
     * @param absence L'entité Absence à convertir
     * @return L'objet AbsenceResponseDto correspondant
     */
    @Override
    public ResponseDto toDto(Object entity) {
        Absence absence = (Absence) entity;
        AbsenceResponseDto dto = new AbsenceResponseDto();
        dto.setId(absence.getId());
        dto.setDateDebut(absence.getDateDebut());
        dto.setDateFin(absence.getDateFin());
        dto.setMotif(absence.getMotif());
        if (absence.getContrat() != null) {
            dto.setContrat((ContratResponseDto) contratService.toDto(absence.getContrat()));
        }
        if (absence.getTypeAbsence() != null) {
            dto.setTypeAbsence(typeAbsenceService.toDto(absence.getTypeAbsence()));
        }
        return dto;
    }



    /**
     * Crée une entité Absence à partir des données fournies.
     *
     * @param absenceRequest Les données de la requête (AbsenceRequestDto)
     * @return L'objet AbsenceResponseDto correspondant
     */
    @Override
    public ResponseDto create(RequestDto request) {
        AbsenceRequestDto absenceRequest = (AbsenceRequestDto) request;
        Contrat contrat = contratRepository.findById(absenceRequest.getContratId()).orElseThrow(() -> new RuntimeException("Contrat non trouvé"));
        TypeAbsence typeAbsence = typeAbsenceRepository.findById(absenceRequest.getTypeAbsenceId()).orElseThrow(() -> new RuntimeException("TypeAbsence non trouvé"));
        Absence absence = toEntity(absenceRequest, contrat, typeAbsence);
        return toDto(absenceRepository.save(absence));
    }

    /**
     * Met à jour l'entité Absence existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Absence à modifier
     * @param absenceRequest Les données de la requête (AbsenceRequestDto)
     * @return L'objet AbsenceResponseDto correspondant
     * @throws RuntimeException Si l'entité Absence n'existe pas
     */
    @Override
    public ResponseDto update(Long id, RequestDto request) {
        AbsenceRequestDto absenceRequest = (AbsenceRequestDto) request;
        Contrat contrat = contratRepository.findById(absenceRequest.getContratId()).orElseThrow(() -> new RuntimeException("Contrat non trouvé"));
        TypeAbsence typeAbsence = typeAbsenceRepository.findById(absenceRequest.getTypeAbsenceId()).orElseThrow(() -> new RuntimeException("TypeAbsence non trouvé"));
        Absence absence = absenceRepository.findById(id).orElseThrow(() -> new RuntimeException("Absence non trouvé"));
        absence.setDateDebut(absenceRequest.getDateDebut());
        absence.setDateFin(absenceRequest.getDateFin());
        absence.setMotif(absenceRequest.getMotif());
        absence.setContrat(contrat);
        absence.setTypeAbsence(typeAbsence);
        return toDto(absenceRepository.save(absence));
    }

}