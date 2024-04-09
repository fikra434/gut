package com.postgresql.gut.models;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String motDePasse;

    @ManyToMany(mappedBy = "membres")
    private Set<Projet> projets = new HashSet<>();

    @OneToMany(mappedBy = "utilisateur")
    private Set<Tache> taches = new HashSet<>();

}
