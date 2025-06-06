package com.trady.service;

import com.trady.model.Entreprise;
import com.trady.repository.EntrepriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    private final EntrepriseRepository entrepriseRepository;

    public EnterpriseService(EntrepriseRepository entrepriseRepository) { this.entrepriseRepository = entrepriseRepository; }

    public List<Entreprise> getAllEnterprise() {
        return entrepriseRepository.findAll();
    }

    public Entreprise saveEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    public Entreprise getEntrepriseById(Long id) {

        return entrepriseRepository.findById(id).orElseThrow(() -> new RuntimeException("entreprise not found"));
    }

    public Entreprise updateEntreprise(Entreprise entreprise, Long id) {
        return entrepriseRepository.findById(id).map(existing -> {
            existing.setNom(entreprise.getNom());
            existing.setSiret(entreprise.getSiret());
            existing.setAdresse(entreprise.getAdresse());
            existing.setActivite(entreprise.getActivite());
            existing.setStatutEnBourse(entreprise.getStatutEnBourse());
            existing.setDirigeant(entreprise.getDirigeant());
            return entrepriseRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("entreprise not found"));
    }

    public Entreprise deleteEntrepriseById(Long id) {
        Entreprise entreprise = entrepriseRepository.findById(id).orElseThrow(() -> new RuntimeException("entreprise not found"));
        entrepriseRepository.delete(entreprise);

        return entreprise;
    }
}
