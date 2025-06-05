package com.trady.controller;


import com.trady.model.Entreprise;
import com.trady.repository.EntrepriseRepository;
import com.trady.service.EnterpriseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entreprises")
public class EntrepriseController {

    private final EnterpriseService entrepriseService;

    public EntrepriseController(EnterpriseService entrepriseService) { this.entrepriseService = entrepriseService; }

    @GetMapping
    public List<Entreprise> getAll() {
        return entrepriseService.getAllEnterprise();
    }

    @PostMapping
    public Entreprise create(@RequestBody Entreprise e) {
        return entrepriseService.saveEntreprise(e);
    }
}
