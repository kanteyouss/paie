package com.paie.paie.service;

import com.paie.paie.dto.VariableResponseDto;
import com.paie.paie.dto.ContratResponseDto;
import com.paie.paie.dto.TypeVariableResponseDto;
import com.paie.paie.entity.Variable;
import com.paie.paie.entity.Contrat;
import com.paie.paie.entity.TypeVariable;
import com.paie.paie.repository.VariableRepository;
import com.paie.paie.service.ContratService;
import com.paie.paie.service.TypeVariableService;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les Variables.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class VariableService {
    private final VariableRepository variableRepository;
    private final ContratService contratService;
    private final TypeVariableService typeVariableService;

    public VariableService(VariableRepository variableRepository, ContratService contratService, TypeVariableService typeVariableService) {
        this.variableRepository = variableRepository;
        this.contratService = contratService;
        this.typeVariableService = typeVariableService;
    }

    /**
     * Convertit une entité Variable en DTO de réponse.
     *
     * @param variable L'entité Variable à convertir
     * @return L'objet VariableResponseDto correspondant
     */
    public VariableResponseDto toDto(Variable variable) {
        VariableResponseDto dto = new VariableResponseDto();
        dto.setId(variable.getId());
        dto.setDateSaisie(variable.getDateSaisie());
        dto.setValeur(variable.getValeur());
        if (variable.getContrat() != null) {
            dto.setContrat(contratService.toDto(variable.getContrat()));
        }
        if (variable.getTypeVariable() != null) {
            dto.setTypeVariable(typeVariableService.toDto(variable.getTypeVariable()));
        }
        return dto;
    }
}