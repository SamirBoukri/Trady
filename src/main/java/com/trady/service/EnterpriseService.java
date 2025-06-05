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
}
