package com.paie.paie.service;

import com.paie.paie.dto.BulletinRequestDto;
import com.paie.paie.dto.BulletinResponseDto;
import com.paie.paie.dto.ContratResponseDto;
import com.paie.paie.entity.Bulletin;
import com.paie.paie.entity.Contrat;
import com.paie.paie.repository.BulletinRepository;
import com.paie.paie.repository.ContratRepository;
import com.paie.paie.service.ContratService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service métier gérant les Bulletins.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class BulletinService {
    private final BulletinRepository bulletinRepository;
    private final ContratRepository contratRepository;
    private final ContratService contratService;

    public BulletinService(BulletinRepository bulletinRepository, ContratRepository contratRepository, ContratService contratService) {
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
    public BulletinResponseDto toDto(Bulletin bulletin) {
        BulletinResponseDto dto = new BulletinResponseDto();
        dto.setId(bulletin.getId());
        dto.setPeriodeMois(bulletin.getPeriodeMois());
        dto.setDateEmission(bulletin.getDateEmission());
        dto.setBrut(bulletin.getBrut());
        dto.setNet(bulletin.getNet());
        if (bulletin.getContrat() != null) {
            dto.setContrat(contratService.toDto(bulletin.getContrat()));
        }
        return dto;
    }

    /**
     * Retourne la liste complète des entités Bulletin.
     *
     * @return La liste des BulletinResponseDto
     */
    public List<BulletinResponseDto> getAllBulletins() {
        return bulletinRepository.findAll().stream().map(this::toDto).toList();
    }

    /**
     * Recherche l'entité Bulletin par son identifiant unique.
     *
     * @param id L'identifiant de l'entité Bulletin recherchée
     * @return L'objet BulletinResponseDto correspondant
     * @throws RuntimeException Si l'entité Bulletin n'existe pas
     */
    public BulletinResponseDto getBulletinById(Long id) {
        Bulletin bulletin = bulletinRepository.findById(id).orElseThrow(() -> new RuntimeException("Bulletin non trouvé"));
        return toDto(bulletin);
    }

    /**
     * Crée une entité Bulletin à partir des données fournies.
     *
     * @param bulletinRequest Les données de la requête (BulletinRequestDto)
     * @return L'objet BulletinResponseDto correspondant
     */
    public BulletinResponseDto createBulletin(BulletinRequestDto bulletinRequest) {
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
    public BulletinResponseDto updateBulletinById(Long id, BulletinRequestDto bulletinRequest) {
        Contrat contrat = contratRepository.findById(bulletinRequest.getContratId()).orElseThrow(() -> new RuntimeException("Contrat non trouvé"));
        Bulletin bulletin = bulletinRepository.findById(id).orElseThrow(() -> new RuntimeException("Bulletin non trouvé"));
        bulletin.setPeriodeMois(bulletinRequest.getPeriodeMois());
        bulletin.setDateEmission(bulletinRequest.getDateEmission());
        bulletin.setBrut(bulletinRequest.getBrut());
        bulletin.setNet(bulletinRequest.getNet());
        bulletin.setContrat(contrat);
        return toDto(bulletinRepository.save(bulletin));
    }

    /**
     * Supprime l'entité Bulletin par son identifiant.
     *
     * @param id L'identifiant de l'entité Bulletin recherchée
     * @return L'objet BulletinResponseDto correspondant
     * @throws RuntimeException Si l'entité Bulletin n'existe pas
     */
    public BulletinResponseDto deleteBulletinById(Long id) {
        Bulletin bulletin = bulletinRepository.findById(id).orElseThrow(() -> new RuntimeException("Bulletin non trouvé"));
        bulletinRepository.deleteById(id);
        return toDto(bulletin);
    }
}