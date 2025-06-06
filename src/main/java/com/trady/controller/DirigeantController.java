package com.trady.controller;

import com.trady.model.Dirigeant;
import com.trady.service.DirigeantService;
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

    @PostMapping
    public Dirigeant create(@RequestBody Dirigeant e) {
        return dirigeantService.saveDirigeant(e);
    }

    @PutMapping("/{id}")
    public Dirigeant update(@PathVariable Long id, @RequestBody Dirigeant e) {
        return dirigeantService.updateDirigeant(id, e);
    }
}
