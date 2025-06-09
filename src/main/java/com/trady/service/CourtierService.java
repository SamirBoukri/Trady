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


}
