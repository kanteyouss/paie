package com.paie.paie.controller;

import com.paie.paie.service.EmployeService;
import org.springframework.web.bind.annotation.*;

/**
 * Contrôleur REST exposant les endpoints de gestion des employés.
 */
@RestController
@RequestMapping("/employes")
public class EmployeController extends CrudController {
    public EmployeController(EmployeService employeService) {
        super(employeService);
    }
}
