package tdRestAPI.td.controllers;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import tdRestAPI.td.models.Joueur;
import tdRestAPI.td.service.JoueurService;

import java.util.List;

@RestController
@NoArgsConstructor
public class JoueurController {

    @Autowired
    private JoueurService joueurService;

    @GetMapping("/joueurs")
    public List<Joueur> allJoueurs(){
        return this.joueurService.findAllPlayers();
    }

    @GetMapping("/joueurs/{id}")
    public Joueur unJoueur(@PathVariable Long id) throws ResourceNotFoundException {

        Joueur result = this.joueurService.findPlayer(id);

        if (result != null) {

            return result;
        }
        else {
            throw new ResourceNotFoundException();
        }
    }
    @PostMapping("/joueurs")
    public Joueur creerJoueur(@RequestBody Joueur joueur) {

        return this.joueurService.createPlayer(joueur);
    }

    @DeleteMapping("/joueurs/{id}")
    public void supprimerJoueur(@PathVariable Long id) {

        this.joueurService.deletePlayer(id);
    }

    @PutMapping("/joueurs/{id}")
    Joueur remplacerJoueur(@RequestBody Joueur team, @PathVariable Long id) {

        Joueur foundPlayer = this.joueurService.findPlayer(id);

        if (team != null) {

            foundPlayer.setNom(team.getNom());

            foundPlayer = this.joueurService.savePlayer(foundPlayer);
        }

        return foundPlayer;
    }


}