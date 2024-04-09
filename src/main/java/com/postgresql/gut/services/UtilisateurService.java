package com.postgresql.gut.services;

import com.postgresql.gut.DAO.UtilisateurRepository;
import com.postgresql.gut.DTO.UtilisateurDTO;
import com.postgresql.gut.constants.GutConstants;
import com.postgresql.gut.models.Utilisateur;
import com.postgresql.gut.utils.GutUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public ResponseEntity<String> ajouterUtilisateur(Map<String, String> requestMap) {
        System.out.println("Inside Ajout Utilisateur:" + requestMap);
        try {
            if (requestMap.containsKey("email")) {
                Utilisateur utilisateur = utilisateurRepository.findByEmail(requestMap.get("email"));

                if (Objects.isNull(utilisateur)) {
                    Utilisateur newUtilisateur = new Utilisateur();

                    newUtilisateur.setEmail(requestMap.get("email"));
                    newUtilisateur.setNom(requestMap.get("nom"));
                    newUtilisateur.setMotDePasse(requestMap.get("motDePasse"));

                    utilisateurRepository.save(newUtilisateur);

                    return GutUtils.getResponseEntity(GutConstants.UTILISATEUR_ENREGISTRE, HttpStatus.OK);

                } else {
                    return GutUtils.getResponseEntity(GutConstants.EXISTE_DEJA, HttpStatus.INTERNAL_SERVER_ERROR);
                }

            } else {
                return GutUtils.getResponseEntity(GutConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return GutUtils.getResponseEntity(GutConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public ResponseEntity<List<UtilisateurDTO>> getUtilisateurs() {
        try {
                List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
                List<UtilisateurDTO> utilisateurDTOs = new ArrayList<>();

                for (Utilisateur utilisateur : utilisateurs) {
                    UtilisateurDTO utilisateurDTO = new UtilisateurDTO();

                    utilisateurDTO.setId(utilisateur.getId());
                    utilisateurDTO.setEmail(utilisateur.getEmail());
                    utilisateurDTO.setNom(utilisateur.getNom());
                    utilisateurDTO.setMotDePasse(utilisateur.getMotDePasse());

                    utilisateurDTOs.add(utilisateurDTO);
                }
                return new ResponseEntity<>(utilisateurDTOs, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<String> supprimerUtilisateur(long id) {
        try {

            Utilisateur utilisateur = utilisateurRepository.findById(id).get();
            utilisateurRepository.delete(utilisateur);
            return GutUtils.getResponseEntity(GutConstants.UTILISATEUR_SUPPRIME, HttpStatus.OK);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return GutUtils.getResponseEntity(GutConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
