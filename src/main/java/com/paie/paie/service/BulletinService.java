package com.paie.paie.service;

import com.paie.paie.dto.RequestDto;
import com.paie.paie.dto.ResponseDto;
import com.paie.paie.dto.BulletinRequestDto;
import com.paie.paie.dto.BulletinResponseDto;
import com.paie.paie.dto.ContratResponseDto;
import com.paie.paie.entity.Bulletin;
import com.paie.paie.entity.Contrat;
import com.paie.paie.repository.BulletinRepository;
import com.paie.paie.repository.ContratRepository;
import com.paie.paie.service.ContratService;
import org.springframework.stereotype.Service;


/**
 * Service métier gérant les Bulletins.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class BulletinService extends AbstractCrudService {
    private final BulletinRepository bulletinRepository;
    private final ContratRepository contratRepository;
    private final ContratService contratService;

    public BulletinService(BulletinRepository bulletinRepository, ContratRepository contratRepository, ContratService contratService) {
        super(bulletinRepository);
        this.bulletinRepository = bulletinRepository;
        this.contratRepository = contratRepository;
        this.contratService = contratService;
    }

    /**
     * Construit une entité Bulletin à partir des données de la requête.
     *
     * @param bulletinRequest Les données de la requête (BulletinRequestDto)
     * @param contrat L'entité Contrat associée
     * @return L'entité Bulletin construite
     */
    public Bulletin toEntity(BulletinRequestDto bulletinRequest, Contrat contrat) {
        Bulletin bulletin = new Bulletin();
        bulletin.setPeriodeMois(bulletinRequest.getPeriodeMois());
        bulletin.setDateEmission(bulletinRequest.getDateEmission());
        bulletin.setBrut(bulletinRequest.getBrut());
        bulletin.setNet(bulletinRequest.getNet());
        bulletin.setContrat(contrat);
        return bulletin;
    }

    /**
     * Convertit une entité Bulletin en DTO de réponse.
     *
     * @param bulletin L'entité Bulletin à convertir
     * @return L'objet BulletinResponseDto correspondant
     */
    @Override
    public ResponseDto toDto(Object entity) {
        Bulletin bulletin = (Bulletin) entity;
        BulletinResponseDto dto = new BulletinResponseDto();
        dto.setId(bulletin.getId());
        dto.setPeriodeMois(bulletin.getPeriodeMois());
        dto.setDateEmission(bulletin.getDateEmission());
        dto.setBrut(bulletin.getBrut());
        dto.setNet(bulletin.getNet());
        if (bulletin.getContrat() != null) {
            dto.setContrat((ContratResponseDto) contratService.toDto(bulletin.getContrat()));
        }
        return dto;
    }



    /**
     * Crée une entité Bulletin à partir des données fournies.
     *
     * @param bulletinRequest Les données de la requête (BulletinRequestDto)
     * @return L'objet BulletinResponseDto correspondant
     */
    @Override
    public ResponseDto create(RequestDto request) {
        BulletinRequestDto bulletinRequest = (BulletinRequestDto) request;
        Contrat contrat = contratRepository.findById(bulletinRequest.getContratId()).orElseThrow(() -> new RuntimeException("Contrat non trouvé"));
        Bulletin bulletin = toEntity(bulletinRequest, contrat);
        return toDto(bulletinRepository.save(bulletin));
    }

    /**
     * Met à jour l'entité Bulletin existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Bulletin à modifier
     * @param bulletinRequest Les données de la requête (BulletinRequestDto)
     * @return L'objet BulletinResponseDto correspondant
     * @throws RuntimeException Si l'entité Bulletin n'existe pas
     */
    @Override
    public ResponseDto update(Long id, RequestDto request) {
        BulletinRequestDto bulletinRequest = (BulletinRequestDto) request;
        Contrat contrat = contratRepository.findById(bulletinRequest.getContratId()).orElseThrow(() -> new RuntimeException("Contrat non trouvé"));
        Bulletin bulletin = bulletinRepository.findById(id).orElseThrow(() -> new RuntimeException("Bulletin non trouvé"));
        bulletin.setPeriodeMois(bulletinRequest.getPeriodeMois());
        bulletin.setDateEmission(bulletinRequest.getDateEmission());
        bulletin.setBrut(bulletinRequest.getBrut());
        bulletin.setNet(bulletinRequest.getNet());
        bulletin.setContrat(contrat);
        return toDto(bulletinRepository.save(bulletin));
    }

}