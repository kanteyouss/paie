package com.paie.paie.service;

import com.paie.paie.dto.RegularisationResponseDto;
import com.paie.paie.dto.BulletinResponseDto;
import com.paie.paie.entity.Regularisation;
import com.paie.paie.entity.Bulletin;
import com.paie.paie.repository.RegularisationRepository;
import com.paie.paie.service.BulletinService;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les Regularisations.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class RegularisationService {
    private final RegularisationRepository regularisationRepository;
    private final BulletinService bulletinService;

    public RegularisationService(RegularisationRepository regularisationRepository, BulletinService bulletinService) {
        this.regularisationRepository = regularisationRepository;
        this.bulletinService = bulletinService;
    }

    /**
     * Convertit une entité Regularisation en DTO de réponse.
     *
     * @param regularisation L'entité Regularisation à convertir
     * @return L'objet RegularisationResponseDto correspondant
     */
    public RegularisationResponseDto toDto(Regularisation regularisation) {
        RegularisationResponseDto dto = new RegularisationResponseDto();
        dto.setId(regularisation.getId());
        dto.setMotif(regularisation.getMotif());
        dto.setMontant(regularisation.getMontant());
        if (regularisation.getBulletin() != null) {
            dto.setBulletin((BulletinResponseDto) bulletinService.toDto(regularisation.getBulletin()));
        }
        return dto;
    }
}