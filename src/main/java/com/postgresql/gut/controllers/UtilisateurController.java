package com.postgresql.gut.controllers;

import com.postgresql.gut.DTO.UtilisateurDTO;
import com.postgresql.gut.constants.GutConstants;
import com.postgresql.gut.services.UtilisateurService;
import com.postgresql.gut.utils.GutUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public ResponseEntity<List<UtilisateurDTO>> getUtilisateurs(){
        try {
            return utilisateurService.getUtilisateurs();

        } catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(value = "/ajouter")
    public ResponseEntity<String> ajouterQuestion(@RequestBody Map<String, String> requestMap){
        try {
            return utilisateurService.ajouterUtilisateur(requestMap);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return GutUtils.getResponseEntity(GutConstants.SOMETHING_WENT_WRONG , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> supprimerUtilisateur(@PathVariable("id") long id){
        try {
            return utilisateurService.supprimerUtilisateur(id);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return GutUtils.getResponseEntity(GutConstants.SOMETHING_WENT_WRONG , HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
