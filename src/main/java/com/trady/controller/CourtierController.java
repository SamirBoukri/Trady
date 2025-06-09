package com.trady.controller;

import com.trady.model.Courtier;
import com.trady.model.Entreprise;
import com.trady.service.CourtierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courtiers")
public class CourtierController {

    private final CourtierService courtierService;

    public CourtierController(CourtierService courtierService) {this.courtierService = courtierService;}

    @GetMapping
    public List<Courtier> getAllCourtiers() {
        return courtierService.getAllCourtiers();
    }

    @PostMapping
    public Courtier createCourtier(@RequestBody Courtier c) {
        return courtierService.saveCourtier(c);
    }

    @PutMapping("/{id}")
    public Courtier  updateCourtier(@PathVariable Long id, @RequestBody Courtier c) {
        return courtierService.updateCourtier(c, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCourtier(@PathVariable Long id) {
        courtierService.deleteCourtier(id);
    }

}
