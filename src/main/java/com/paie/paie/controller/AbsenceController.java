package com.paie.paie.controller;

import com.paie.paie.service.AbsenceService;
import org.springframework.web.bind.annotation.*;

/**
 * Contrôleur REST exposant les endpoints de gestion des absences.
 */
@RestController
@RequestMapping("/absences")
public class AbsenceController extends CrudController {
    public AbsenceController(AbsenceService absenceService) {
        super(absenceService);
    }
}
