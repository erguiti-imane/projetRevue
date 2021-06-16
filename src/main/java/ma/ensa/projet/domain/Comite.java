package ma.ensa.projet.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter @NoArgsConstructor
public class Comite  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="revue",updatable=false,nullable=false)
    private Revue revue;
    @OneToOne
    private User user;
}
