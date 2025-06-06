package com.trady.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trady.model.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
}
