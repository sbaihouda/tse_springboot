package tdRestAPI.td.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tdRestAPI.td.models.Equipe;

import java.util.List;

@Service
public interface EquipeService {

    @Transactional(readOnly = true)
    List<Equipe> findAllTeams();

    @Transactional(readOnly = true)
    Equipe findTeam(Long id);

    Equipe createTeam(Equipe player);

    void deleteTeam(Long id);

    Equipe saveTeam(Equipe foundPlayer);
}
