package tdRestAPI.td.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tdRestAPI.td.models.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {
}
