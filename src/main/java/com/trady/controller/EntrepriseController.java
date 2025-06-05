package com.trady.controller;


import com.trady.model.Entreprise;
import com.trady.repository.EntrepriseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entreprises")
public class EntrepriseController {
    private final EntrepriseRepository repository;

    public EntrepriseController(EntrepriseRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Entreprise> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Entreprise create(@RequestBody Entreprise e) {
        return repository.save(e);
    }
}
