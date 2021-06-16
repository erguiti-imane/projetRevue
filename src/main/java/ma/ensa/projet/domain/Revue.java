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
public class Revue implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String politique;
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL,mappedBy="revue",fetch=FetchType.LAZY)
    private List<Comite> comites;
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL,mappedBy="revue",fetch=FetchType.LAZY)
    private List<Article> articles;


}
