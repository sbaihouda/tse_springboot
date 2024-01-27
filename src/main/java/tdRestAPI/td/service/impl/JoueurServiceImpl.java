package tdRestAPI.td.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tdRestAPI.td.models.Equipe;
import tdRestAPI.td.models.Joueur;
import tdRestAPI.td.repositories.JoueurRepository;
import tdRestAPI.td.service.JoueurService;

import java.util.List;

@Service
public class JoueurServiceImpl implements JoueurService {
    @Autowired
    private JoueurRepository joueurRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Joueur> findAllPlayers() {
        return this.joueurRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Joueur findPlayer(Long id) {
        return this.joueurRepository.findById(id).orElse(null);
    }

    @Override
    public Joueur createPlayer(Joueur joueur) {
        return this.joueurRepository.save(joueur);
    }

    @Override
    public void deletePlayer(Long id) {
        this.joueurRepository.deleteById(id);
    }

    @Override
    public Joueur savePlayer(Joueur joueur) {
        return this.joueurRepository.save(joueur);
    }
}
