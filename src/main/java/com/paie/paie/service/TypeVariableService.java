package com.paie.paie.service;

import com.paie.paie.dto.TypeVariableResponseDto;
import com.paie.paie.entity.TypeVariable;
import com.paie.paie.repository.TypeVariableRepository;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les TypeVariables.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class TypeVariableService {
    private final TypeVariableRepository typeVariableRepository;

    public TypeVariableService(TypeVariableRepository typeVariableRepository) {
        this.typeVariableRepository = typeVariableRepository;
    }

    /**
     * Convertit une entité TypeVariable en DTO de réponse.
     *
     * @param typeVariable L'entité TypeVariable à convertir
     * @return L'objet TypeVariableResponseDto correspondant
     */
    public TypeVariableResponseDto toDto(TypeVariable typeVariable) {
        TypeVariableResponseDto dto = new TypeVariableResponseDto();
        dto.setId(typeVariable.getId());
        dto.setLibelle(typeVariable.getLibelle());
        return dto;
    }
}