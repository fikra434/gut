package com.postgresql.gut.controllers;

import com.postgresql.gut.services.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/taches")
public class TacheController {

    @Autowired
    private TacheService tacheService;
}
