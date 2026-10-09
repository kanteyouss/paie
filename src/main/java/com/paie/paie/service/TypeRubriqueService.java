package com.paie.paie.service;

import com.paie.paie.dto.TypeRubriqueResponseDto;
import com.paie.paie.entity.TypeRubrique;
import com.paie.paie.repository.TypeRubriqueRepository;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les TypeRubriques.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class TypeRubriqueService {
    private final TypeRubriqueRepository typeRubriqueRepository;

    public TypeRubriqueService(TypeRubriqueRepository typeRubriqueRepository) {
        this.typeRubriqueRepository = typeRubriqueRepository;
    }

    /**
     * Convertit une entité TypeRubrique en DTO de réponse.
     *
     * @param typeRubrique L'entité TypeRubrique à convertir
     * @return L'objet TypeRubriqueResponseDto correspondant
     */
    public TypeRubriqueResponseDto toDto(TypeRubrique typeRubrique) {
        TypeRubriqueResponseDto dto = new TypeRubriqueResponseDto();
        dto.setId(typeRubrique.getId());
        dto.setLibelle(typeRubrique.getLibelle());
        return dto;
    }
}