package tdRestAPI.td.controllers;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Joueur> allPlayers(){
        return this.joueurService.findAllPlayers();
    }

    @PostMapping("/joueurs")
    public Joueur createPlayer(@RequestBody Joueur joueur) {

        return this.joueurService.createPlayer(joueur);
    }

    @DeleteMapping("/joueur/{id}")
    public void deletePlayer(@PathVariable Long id) {

        this.joueurService.deletePlayer(id);
    }

    @PutMapping("/joueur/{id}")
    Joueur replacePlayer(@RequestBody Joueur team, @PathVariable Long id) {

        Joueur foundPlayer = this.joueurService.findPlayer(id);

        if (team != null) {

            foundPlayer.setName(team.getName());

            foundPlayer = this.joueurService.savePlayer(foundPlayer);
        }

        return foundPlayer;
    }


}