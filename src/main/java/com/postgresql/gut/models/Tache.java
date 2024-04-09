package com.postgresql.gut.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tache")
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutTache statut;

    @Column(name = "date_limite")
    private LocalDate dateLimite;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "projet_id")
    private Projet projet;

}

enum StatutTache {
    TODO,
    EN_COURS,
    TERMINE
}
