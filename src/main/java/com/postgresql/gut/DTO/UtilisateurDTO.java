package com.postgresql.gut.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UtilisateurDTO {

    private Long id;
    private String email;
    private String nom;
    private String motDePasse;

}
