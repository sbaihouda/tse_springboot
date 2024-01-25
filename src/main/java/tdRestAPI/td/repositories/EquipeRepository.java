package tdRestAPI.td.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tdRestAPI.td.models.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
}
