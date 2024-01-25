package tdRestAPI.td;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tdRestAPI.td.models.Joueur;
import tdRestAPI.td.service.JoueurService;

import java.util.Collection;

@SpringBootTest
@ActiveProfiles("test")
public class JoueurServiceTest {

    @Autowired
    private JoueurService joueurService;

    @Test
    public void testCreatePlayer(){
        Joueur joueur = new Joueur();
        joueur.setName("Messi");
        joueur = this.joueurService.createPlayer(joueur);
        Collection<Joueur> allPlayers = this.joueurService.findAllPlayers();

    }

    @Test
    public void testFindAllPlayers(){
        Collection<Joueur> allPlayers = this.joueurService.findAllPlayers();
    }
}
