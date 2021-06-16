package ma.ensa.projet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class AuteurCorr implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String affiliation;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "article", referencedColumnName = "id")
    private Article article;
    @OneToOne
    private User user;
}
