package ma.ensa.projet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Commentaire implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String qualification ;
    private String commentaire;
    @ManyToOne
    @JoinColumn(name="article",updatable=false,nullable=false)
    private Article article;

    @ManyToOne
    @JoinColumn(name="refere",updatable=false,nullable=false)
    private Refere refere;
    @OneToOne
    private User user;

}
