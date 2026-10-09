package com.paie.paie.controller;

import com.paie.paie.dto.BulletinRequestDto;
import com.paie.paie.dto.BulletinResponseDto;
import com.paie.paie.service.BulletinService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST exposant les endpoints des Bulletins.
 */
@RestController
@RequestMapping("/bulletins")
public class BulletinController {
    private final BulletinService bulletinService;

    public BulletinController(BulletinService bulletinService) {
        this.bulletinService = bulletinService;
    }

    /**
     * Retourne la liste complète des entités Bulletin.
     *
     * @return La liste des BulletinResponseDto
     */
    @GetMapping
    public List<BulletinResponseDto> getAllBulletins() {
        return bulletinService.getAllBulletins();
    }

    /**
     * Recherche l'entité Bulletin par son identifiant unique.
     *
     * @param id L'identifiant de l'entité Bulletin recherchée
     * @return L'objet BulletinResponseDto correspondant
     * @throws RuntimeException Si l'entité Bulletin n'existe pas
     */
    @GetMapping("/{id}")
    public BulletinResponseDto getBulletinById(@PathVariable Long id) {
        return bulletinService.getBulletinById(id);
    }

    /**
     * Crée une entité Bulletin à partir des données fournies.
     *
     * @param bulletinRequest Les données de la requête (BulletinRequestDto)
     * @return L'objet BulletinResponseDto correspondant
     */
    @PostMapping
    public BulletinResponseDto createBulletin(@RequestBody BulletinRequestDto bulletinRequest) {
        return bulletinService.createBulletin(bulletinRequest);
    }

    /**
     * Met à jour l'entité Bulletin existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Bulletin à modifier
     * @param bulletinRequest Les données de la requête (BulletinRequestDto)
     * @return L'objet BulletinResponseDto correspondant
     * @throws RuntimeException Si l'entité Bulletin n'existe pas
     */
    @PutMapping("/{id}")
    public BulletinResponseDto updateBulletinById(@PathVariable Long id, @RequestBody BulletinRequestDto bulletinRequest) {
        return bulletinService.updateBulletinById(id, bulletinRequest);
    }

    /**
     * Supprime l'entité Bulletin par son identifiant.
     *
     * @param id L'identifiant de l'entité Bulletin recherchée
     * @return L'objet BulletinResponseDto correspondant
     * @throws RuntimeException Si l'entité Bulletin n'existe pas
     */
    @DeleteMapping("/{id}")
    public BulletinResponseDto deleteBulletinById(@PathVariable Long id) {
        return bulletinService.deleteBulletinById(id);
    }
}
