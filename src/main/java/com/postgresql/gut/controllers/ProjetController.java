package com.postgresql.gut.controllers;

import com.postgresql.gut.services.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/projets")
public class ProjetController {

    @Autowired
    private ProjetService projetService;
}
