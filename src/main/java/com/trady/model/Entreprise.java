package com.trady.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Entreprise {

    @Id
    private String siret;

    private String nom;
    private String adresse;
    private String activite;
    private String statutEnBourse; // exemple : Proposée / Validée / Refusée

}
