package com.paie.paie.controller;

import com.paie.paie.service.RubriqueService;
import org.springframework.web.bind.annotation.*;

/**
 * Contrôleur REST exposant les endpoints de gestion des rubriques.
 */
@RestController
@RequestMapping("/rubriques")
public class RubriqueController extends CrudController {
    public RubriqueController(RubriqueService rubriqueService) {
        super(rubriqueService);
    }
}
