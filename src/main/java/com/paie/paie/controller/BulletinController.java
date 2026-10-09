package com.paie.paie.controller;

import com.paie.paie.service.BulletinService;
import org.springframework.web.bind.annotation.*;

/**
 * Contrôleur REST exposant les endpoints de gestion des bulletins.
 */
@RestController
@RequestMapping("/bulletins")
public class BulletinController extends CrudController {
    public BulletinController(BulletinService bulletinService) {
        super(bulletinService);
    }
}
