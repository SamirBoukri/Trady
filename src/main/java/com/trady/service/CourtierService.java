package com.trady.service;

import com.trady.model.Courtier;
import com.trady.repository.CourtierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourtierService {
    private CourtierRepository courtierRepository;

    public CourtierService(CourtierRepository courtierRepository) {
        this.courtierRepository = courtierRepository;
    }

    public List<Courtier> getAllCourtiers() {return courtierRepository.findAll();};

    public Courtier saveCourtier(Courtier courtier) {return courtierRepository.save(courtier);};

    public Courtier updateCourtier(Courtier courtier, Long id) {
        return courtierRepository.findById(id).map(existing -> {
            existing.setNom(courtier.getNom());
            existing.setPrenom(courtier.getPrenom());
            return courtierRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Courtier non trouvé"));
    }

    public void deleteCourtier(Long id) {
        courtierRepository.deleteById(id);
    }
}
