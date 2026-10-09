package com.paie.paie.service;

import com.paie.paie.dto.TypeAbsenceResponseDto;
import com.paie.paie.entity.TypeAbsence;
import com.paie.paie.repository.TypeAbsenceRepository;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les TypeAbsences.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class TypeAbsenceService {
    private final TypeAbsenceRepository typeAbsenceRepository;

    public TypeAbsenceService(TypeAbsenceRepository typeAbsenceRepository) {
        this.typeAbsenceRepository = typeAbsenceRepository;
    }

    /**
     * Convertit une entité TypeAbsence en DTO de réponse.
     *
     * @param typeAbsence L'entité TypeAbsence à convertir
     * @return L'objet TypeAbsenceResponseDto correspondant
     */
    public TypeAbsenceResponseDto toDto(TypeAbsence typeAbsence) {
        TypeAbsenceResponseDto dto = new TypeAbsenceResponseDto();
        dto.setId(typeAbsence.getId());
        dto.setLibelle(typeAbsence.getLibelle());
        return dto;
    }
}