package com.paie.paie.controller;

import com.paie.paie.service.ContratService;
import org.springframework.web.bind.annotation.*;

/**
 * Contrôleur REST exposant les endpoints de gestion des contrats.
 */
@RestController
@RequestMapping("/contrats")
public class ContratController extends CrudController {
    public ContratController(ContratService contratService) {
        super(contratService);
    }
}
