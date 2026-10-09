package com.paie.paie.service;

import com.paie.paie.dto.CongeResponseDto;
import com.paie.paie.dto.ContratResponseDto;
import com.paie.paie.entity.Conge;
import com.paie.paie.entity.Contrat;
import com.paie.paie.repository.CongeRepository;
import com.paie.paie.service.ContratService;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les Conges.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class CongeService {
    private final CongeRepository congeRepository;
    private final ContratService contratService;

    public CongeService(CongeRepository congeRepository, ContratService contratService) {
        this.congeRepository = congeRepository;
        this.contratService = contratService;
    }

    /**
     * Convertit une entité Conge en DTO de réponse.
     *
     * @param conge L'entité Conge à convertir
     * @return L'objet CongeResponseDto correspondant
     */
    public CongeResponseDto toDto(Conge conge) {
        CongeResponseDto dto = new CongeResponseDto();
        dto.setId(conge.getId());
        dto.setPeriode(conge.getPeriode());
        dto.setSoldeJours(conge.getSoldeJours());
        if (conge.getContrat() != null) {
            dto.setContrat(contratService.toDto(conge.getContrat()));
        }
        return dto;
    }
}