package tdRestAPI.td.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tdRestAPI.td.models.Equipe;
import tdRestAPI.td.models.Joueur;
import tdRestAPI.td.repositories.EquipeRepository;
import tdRestAPI.td.service.EquipeService;

import java.util.Date;
import java.util.List;

@Service
public class EquipeServiceImpl implements EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Equipe> getTeams() {
        return this.equipeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Equipe findTeam(Long id) {
        return this.equipeRepository.findById(id).orElse(null);
    }

    @Override
    public Equipe createTeam(Equipe team) {
        return this.equipeRepository.save(team);
    }

    @Override
    public void deleteTeam(Long id) {
        this.equipeRepository.deleteById(id);
    }

    @Override
    public Equipe saveTeam(Equipe foundPlayer) {
        return this.equipeRepository.save(foundPlayer);
    }

}
