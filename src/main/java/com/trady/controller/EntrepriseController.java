package com.trady.controller;


import com.trady.model.Entreprise;
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

    @GetMapping("/{id}")
    public Entreprise getById(@PathVariable Long id) { return entrepriseService.getEntrepriseById(id); }

    @PostMapping
    public Entreprise create(@RequestBody Entreprise e) {
        return entrepriseService.saveEntreprise(e);
    }

    @DeleteMapping("/{id}")
    public Entreprise delete(@PathVariable Long id) {
        return entrepriseService.deleteEntrepriseById(id);
    }

    @PutMapping("/{id}")
    public Entreprise update(@PathVariable Long id, @RequestBody Entreprise e) {
        return entrepriseService.updateEntreprise(e, id);
    }
}
