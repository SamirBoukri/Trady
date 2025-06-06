package com.trady.controller;

import com.trady.model.Dirigeant;
import com.trady.service.DirigeantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dirigeants")
public class DirigeantController {
    private final DirigeantService dirigeantService;

    public DirigeantController(DirigeantService dirigeantService) { this.dirigeantService = dirigeantService; }

    @GetMapping
    public List<Dirigeant> getAll() {
        return dirigeantService.getAllDirigeant();
    }

    @GetMapping("/{id}")
    public Dirigeant getDirigeantByid(@PathVariable Long id) {
        return dirigeantService.getDirigeantById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirigeantByid(@PathVariable Long id) {
        dirigeantService.deleteDirigeantByid(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public Dirigeant create(@RequestBody Dirigeant e) {
        return dirigeantService.saveDirigeant(e);
    }

    @PutMapping("/{id}")
    public Dirigeant update(@PathVariable Long id, @RequestBody Dirigeant e) {
        return dirigeantService.updateDirigeant(id, e);
    }

    @PatchMapping("/{id}/entreprises")
    public Dirigeant updateDirigentEntreprises(@PathVariable Long id, @RequestBody List<Long> entrepriseIds) {
        return dirigeantService.updateDirigeantEntreprise(id, entrepriseIds);
    }
}
