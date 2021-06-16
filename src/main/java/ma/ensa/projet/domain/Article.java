package ma.ensa.projet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String  resume;
    @ElementCollection
    private List<String> motCles;
    private String contenu;
    private String etat;
    private boolean politique;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="revue",nullable = false)
    private Revue revue;
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL,mappedBy="article",fetch=FetchType.LAZY)
    private List<Commentaire> commentaires;

    @OneToMany(cascade=CascadeType.ALL,mappedBy="article",fetch=FetchType.LAZY)
    private List<Auteur> auteurs ;

    @OneToOne(mappedBy = "article")
    private AuteurCorr aut;


}
