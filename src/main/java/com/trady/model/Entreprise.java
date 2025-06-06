package com.trady.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String siret;

    private String nom;
    private String adresse;
    private String activite;
    private String statutEnBourse; // exemple : Proposée / Validée / Refusée

    @ManyToOne
    @JoinColumn(name="dirigeant_id")
    @JsonBackReference
    private Dirigeant dirigeant;
}
