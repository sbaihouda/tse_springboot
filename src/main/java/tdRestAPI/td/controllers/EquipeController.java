package tdRestAPI.td.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tdRestAPI.td.models.Equipe;
import tdRestAPI.td.models.Joueur;
import tdRestAPI.td.service.EquipeService;
import tdRestAPI.td.service.JoueurService;

import java.util.List;


@RestController
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    @GetMapping("/equipes")
    public List<Equipe> allTeams(){
        return this.equipeService.findAllTeams();
    }

    @PostMapping("/equipe")
    public Equipe createPlayer(@RequestBody Equipe equipe) {

        return this.equipeService.createTeam(equipe);
    }

    @DeleteMapping("/equipe/{id}")
    public void deletePlayer(@PathVariable Long id) {

        this.equipeService.deleteTeam(id);
    }

    @PutMapping("/equipe/{id}")
    Equipe replacePlayer(@RequestBody Joueur team, @PathVariable Long id) {

        Equipe foundPlayer = this.equipeService.findTeam(id);

        if (team != null) {

            foundPlayer.setName(team.getName());

            foundPlayer = this.equipeService.saveTeam(foundPlayer);
        }

        return foundPlayer;
    }


}
