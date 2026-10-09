package com.paie.paie.service;

import com.paie.paie.dto.RequestDto;
import com.paie.paie.dto.ResponseDto;
import com.paie.paie.dto.ContratRequestDto;
import com.paie.paie.dto.ContratResponseDto;
import com.paie.paie.dto.EmployeResponseDto;
import com.paie.paie.dto.StatutContratResponseDto;
import com.paie.paie.entity.Contrat;
import com.paie.paie.entity.Employe;
import com.paie.paie.entity.StatutContrat;
import com.paie.paie.repository.ContratRepository;
import com.paie.paie.repository.EmployeRepository;
import com.paie.paie.repository.StatutContratRepository;
import com.paie.paie.service.EmployeService;
import com.paie.paie.service.StatutContratService;
import org.springframework.stereotype.Service;


/**
 * Service métier gérant les Contrats.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class ContratService extends AbstractCrudService {
    private final ContratRepository contratRepository;
    private final EmployeRepository employeRepository;
    private final EmployeService employeService;
    private final StatutContratRepository statutContratRepository;
    private final StatutContratService statutContratService;

    public ContratService(ContratRepository contratRepository, EmployeRepository employeRepository, EmployeService employeService, StatutContratRepository statutContratRepository, StatutContratService statutContratService) {
        super(contratRepository);
        this.contratRepository = contratRepository;
        this.employeRepository = employeRepository;
        this.employeService = employeService;
        this.statutContratRepository = statutContratRepository;
        this.statutContratService = statutContratService;
    }

    /**
     * Construit une entité Contrat à partir des données de la requête.
     *
     * @param contratRequest Les données de la requête (ContratRequestDto)
     * @param employe L'entité Employe associée
     * @param statutContrat L'entité StatutContrat associée
     * @return L'entité Contrat construite
     */
    public Contrat toEntity(ContratRequestDto contratRequest, Employe employe, StatutContrat statutContrat) {
        Contrat contrat = new Contrat();
        contrat.setDateDebut(contratRequest.getDateDebut());
        contrat.setDateFin(contratRequest.getDateFin());
        contrat.setPoste(contratRequest.getPoste());
        contrat.setSalaireBase(contratRequest.getSalaireBase());
        contrat.setTempsTravail(contratRequest.getTempsTravail());
        contrat.setDateCreation(contratRequest.getDateCreation());
        contrat.setType(contratRequest.getType());
        contrat.setEmploye(employe);
        contrat.setStatutContrat(statutContrat);
        return contrat;
    }

    /**
     * Convertit une entité Contrat en DTO de réponse.
     *
     * @param contrat L'entité Contrat à convertir
     * @return L'objet ContratResponseDto correspondant
     */
    @Override
    public ResponseDto toDto(Object entity) {
        Contrat contrat = (Contrat) entity;
        ContratResponseDto dto = new ContratResponseDto();
        dto.setId(contrat.getId());
        dto.setDateDebut(contrat.getDateDebut());
        dto.setDateFin(contrat.getDateFin());
        dto.setPoste(contrat.getPoste());
        dto.setSalaireBase(contrat.getSalaireBase());
        dto.setTempsTravail(contrat.getTempsTravail());
        dto.setDateCreation(contrat.getDateCreation());
        dto.setType(contrat.getType());
        if (contrat.getEmploye() != null) {
            dto.setEmploye((EmployeResponseDto) employeService.toDto(contrat.getEmploye()));
        }
        if (contrat.getStatutContrat() != null) {
            dto.setStatutContrat(statutContratService.toDto(contrat.getStatutContrat()));
        }
        return dto;
    }



    /**
     * Crée une entité Contrat à partir des données fournies.
     *
     * @param contratRequest Les données de la requête (ContratRequestDto)
     * @return L'objet ContratResponseDto correspondant
     */
    @Override
    public ResponseDto create(RequestDto request) {
        ContratRequestDto contratRequest = (ContratRequestDto) request;
        Employe employe = employeRepository.findById(contratRequest.getEmployeId()).orElseThrow(() -> new RuntimeException("Employe non trouvé"));
        StatutContrat statutContrat = statutContratRepository.findById(contratRequest.getStatutContratId()).orElseThrow(() -> new RuntimeException("StatutContrat non trouvé"));
        Contrat contrat = toEntity(contratRequest, employe, statutContrat);
        return toDto(contratRepository.save(contrat));
    }

    /**
     * Met à jour l'entité Contrat existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Contrat à modifier
     * @param contratRequest Les données de la requête (ContratRequestDto)
     * @return L'objet ContratResponseDto correspondant
     * @throws RuntimeException Si l'entité Contrat n'existe pas
     */
    @Override
    public ResponseDto update(Long id, RequestDto request) {
        ContratRequestDto contratRequest = (ContratRequestDto) request;
        Employe employe = employeRepository.findById(contratRequest.getEmployeId()).orElseThrow(() -> new RuntimeException("Employe non trouvé"));
        StatutContrat statutContrat = statutContratRepository.findById(contratRequest.getStatutContratId()).orElseThrow(() -> new RuntimeException("StatutContrat non trouvé"));
        Contrat contrat = contratRepository.findById(id).orElseThrow(() -> new RuntimeException("Contrat non trouvé"));
        contrat.setDateDebut(contratRequest.getDateDebut());
        contrat.setDateFin(contratRequest.getDateFin());
        contrat.setPoste(contratRequest.getPoste());
        contrat.setSalaireBase(contratRequest.getSalaireBase());
        contrat.setTempsTravail(contratRequest.getTempsTravail());
        contrat.setDateCreation(contratRequest.getDateCreation());
        contrat.setType(contratRequest.getType());
        contrat.setEmploye(employe);
        contrat.setStatutContrat(statutContrat);
        return toDto(contratRepository.save(contrat));
    }

}