package com.paie.paie.service;

import com.paie.paie.dto.RequestDto;
import com.paie.paie.dto.ResponseDto;
import com.paie.paie.dto.EmployeRequestDto;
import com.paie.paie.dto.EmployeResponseDto;
import com.paie.paie.entity.Employe;
import com.paie.paie.repository.EmployeRepository;
import org.springframework.stereotype.Service;


/**
 * Service métier gérant les Employes.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class EmployeService extends AbstractCrudService {
    private final EmployeRepository employeRepository;

    public EmployeService(EmployeRepository employeRepository) {
        super(employeRepository);
        this.employeRepository = employeRepository;
    }

    /**
     * Construit une entité Employe à partir des données de la requête.
     *
     * @param employeRequest Les données de la requête (EmployeRequestDto)
     * @return L'entité Employe construite
     */
    public Employe toEntity(EmployeRequestDto employeRequest) {
        Employe employe = new Employe();
        employe.setNom(employeRequest.getNom());
        employe.setPrenom(employeRequest.getPrenom());
        employe.setMatricule(employeRequest.getMatricule());
        employe.setDateEmbauche(employeRequest.getDateEmbauche());
        employe.setService(employeRequest.getService());
        return employe;
    }

    /**
     * Convertit une entité Employe en DTO de réponse.
     *
     * @param employe L'entité Employe à convertir
     * @return L'objet EmployeResponseDto correspondant
     */
    @Override
    public ResponseDto toDto(Object entity) {
        Employe employe = (Employe) entity;
        EmployeResponseDto dto = new EmployeResponseDto();
        dto.setId(employe.getId());
        dto.setNom(employe.getNom());
        dto.setPrenom(employe.getPrenom());
        dto.setMatricule(employe.getMatricule());
        dto.setDateEmbauche(employe.getDateEmbauche());
        dto.setService(employe.getService());
        return dto;
    }



    /**
     * Crée une entité Employe à partir des données fournies.
     *
     * @param employeRequest Les données de la requête (EmployeRequestDto)
     * @return L'objet EmployeResponseDto correspondant
     */
    @Override
    public ResponseDto create(RequestDto request) {
        EmployeRequestDto employeRequest = (EmployeRequestDto) request;
        Employe employe = toEntity(employeRequest);
        return toDto(employeRepository.save(employe));
    }

    /**
     * Met à jour l'entité Employe existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Employe à modifier
     * @param employeRequest Les données de la requête (EmployeRequestDto)
     * @return L'objet EmployeResponseDto correspondant
     * @throws RuntimeException Si l'entité Employe n'existe pas
     */
    @Override
    public ResponseDto update(Long id, RequestDto request) {
        EmployeRequestDto employeRequest = (EmployeRequestDto) request;
        Employe employe = employeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employe non trouvé"));
        employe.setNom(employeRequest.getNom());
        employe.setPrenom(employeRequest.getPrenom());
        employe.setMatricule(employeRequest.getMatricule());
        employe.setDateEmbauche(employeRequest.getDateEmbauche());
        employe.setService(employeRequest.getService());
        return toDto(employeRepository.save(employe));
    }

}