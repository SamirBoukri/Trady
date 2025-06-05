package com.trady.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Courtier {

    @Id
    private int siret;

    private String nom;
    private String prenom;


}
