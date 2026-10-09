package com.paie.paie.service;

import com.paie.paie.dto.StatutContratResponseDto;
import com.paie.paie.entity.StatutContrat;
import com.paie.paie.repository.StatutContratRepository;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les StatutContrats.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class StatutContratService {
    private final StatutContratRepository statutContratRepository;

    public StatutContratService(StatutContratRepository statutContratRepository) {
        this.statutContratRepository = statutContratRepository;
    }

    /**
     * Convertit une entité StatutContrat en DTO de réponse.
     *
     * @param statutContrat L'entité StatutContrat à convertir
     * @return L'objet StatutContratResponseDto correspondant
     */
    public StatutContratResponseDto toDto(StatutContrat statutContrat) {
        StatutContratResponseDto dto = new StatutContratResponseDto();
        dto.setId(statutContrat.getId());
        dto.setLibelle(statutContrat.getLibelle());
        return dto;
    }
}