package com.postgresql.gut.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "projet")
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    private String description;

    @Column(name = "date_de_debut")
    private LocalDate dateDeDebut;

    @Column(name = "date_de_fin")
    private LocalDate dateDeFin;

    @ManyToMany
    @JoinTable(
            name = "projet_membres",
            joinColumns = @JoinColumn(name = "projet_id"),
            inverseJoinColumns = @JoinColumn(name = "utilisateur_id"))
    private Set<Utilisateur> membres = new HashSet<>();

    @OneToMany(mappedBy = "projet")
    private Set<Tache> taches = new HashSet<>();

}
