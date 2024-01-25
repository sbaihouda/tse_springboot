package tdRestAPI.td.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tdRestAPI.td.models.Equipe;
import tdRestAPI.td.models.Joueur;

import java.util.List;

@Service
public interface JoueurService {


    @Transactional(readOnly = true)
    List<Joueur> findAllPlayers();

    @Transactional(readOnly = true)
    Joueur findPlayer(Long id);

    Joueur createPlayer(Joueur joueur);

    void deletePlayer(Long id);

    Joueur savePlayer(Joueur joueur);
}
