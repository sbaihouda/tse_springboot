package tdRestAPI.td.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "joueurs")
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_de_naissance")
    private Date dateDeNaissance;

    @ManyToOne
    @JoinColumn(name = "equipe_id", referencedColumnName = "id")
    private Equipe equipe;

}
