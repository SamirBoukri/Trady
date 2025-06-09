package com.trady.repository;

import com.trady.model.Courtier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtierRepository extends JpaRepository<Courtier, Long> {
}
