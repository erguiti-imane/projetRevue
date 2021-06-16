package ma.ensa.projet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter @Setter @NoArgsConstructor
public class Auteur implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String affiliation;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="article",updatable=false,nullable=false)
    private Article article;


}
