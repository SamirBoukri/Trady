package com.trady.service;

import com.trady.model.Dirigeant;
import com.trady.repository.DirigeantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirigeantService {
    private final DirigeantRepository dirigeantRepository;

    public DirigeantService(DirigeantRepository dirigeantRepository) { this.dirigeantRepository = dirigeantRepository; }

    public List<Dirigeant> getAllDirigeant() {
        return dirigeantRepository.findAll();
    }

    public Dirigeant saveDirigeant(Dirigeant dirigeant) {
        return dirigeantRepository.save(dirigeant);
    }

    public Dirigeant updateDirigeant(long id, Dirigeant dirigeant) {
        return dirigeantRepository.findById(id)
                .map(existing -> {
                    existing.setNom(dirigeant.getNom());
                    existing.setPrenom(dirigeant.getPrenom());
                    existing.setDateDeNaissance(dirigeant.getDateDeNaissance());
                    existing.setEntreprises(dirigeant.getEntreprises());
                    return dirigeantRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Dirigeant non trouvé"));
    }
}
