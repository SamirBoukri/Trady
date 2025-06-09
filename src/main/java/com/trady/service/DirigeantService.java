package com.trady.service;

import com.trady.model.Dirigeant;
import com.trady.model.Entreprise;
import com.trady.repository.DirigeantRepository;
import com.trady.repository.EntrepriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirigeantService {
    private final DirigeantRepository dirigeantRepository;

    private final EntrepriseRepository entrepriseRepository;

    public DirigeantService(DirigeantRepository dirigeantRepository, EntrepriseRepository entrepriseRepository) {
        this.dirigeantRepository = dirigeantRepository;
        this.entrepriseRepository = entrepriseRepository;
    }

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

    public Dirigeant updateDirigeantEntreprise(long id, List<Long> entreprisesIds) {
        Dirigeant dirigeant = null;
        Optional<Dirigeant> dirigeantOptional = dirigeantRepository.findById(id);
        if (dirigeantOptional.isPresent()) {
            dirigeant = dirigeantOptional.get();
        }

        List<Entreprise> entreprises = entrepriseRepository.findAllById(entreprisesIds);

        for(Entreprise entreprise : entreprises) {
            entreprise.setDirigeant(dirigeant);
        }

        entrepriseRepository.saveAll(entreprises);

        return dirigeant;
    }
}
