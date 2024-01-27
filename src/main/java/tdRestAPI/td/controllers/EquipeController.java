package tdRestAPI.td.controllers;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import tdRestAPI.td.models.Equipe;
import tdRestAPI.td.models.Joueur;
import tdRestAPI.td.service.EquipeService;

import java.util.List;


@RestController
@NoArgsConstructor
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    @GetMapping("/equipes")
    public List<Equipe> getEquipes(){
        return this.equipeService.getTeams();
    }

    @GetMapping("/equipes/{id}")
    public Equipe getEquipe(@PathVariable Long id) throws ResourceNotFoundException {

        Equipe result = this.equipeService.findTeam(id);

        if (result != null) {

            return result;
        }
        else {
            throw new ResourceNotFoundException();
        }
    }
    @PostMapping("/equipes")
    public Equipe postEquipe(@RequestBody Equipe equipe) {

        return this.equipeService.createTeam(equipe);
    }

    @DeleteMapping("/equipes/{id}")
    public void deleteEquipe(@PathVariable Long id) {

        this.equipeService.deleteTeam(id);
    }

    @PutMapping("/equipes/{id}")
    Equipe remplacerEquipe(@RequestBody Joueur team, @PathVariable Long id) {

        Equipe foundPlayer = this.equipeService.findTeam(id);

        if (team != null) {

            foundPlayer.setNom(team.getNom());

            foundPlayer = this.equipeService.saveTeam(foundPlayer);
        }

        return foundPlayer;
    }


}
