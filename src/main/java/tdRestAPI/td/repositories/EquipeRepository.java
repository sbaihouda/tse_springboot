package tdRestAPI.td.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tdRestAPI.td.models.Equipe;
import tdRestAPI.td.models.Joueur;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

}



