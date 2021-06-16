package ma.ensa.projet.repository;

import ma.ensa.projet.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
      public List<Commentaire> findByRefere(Refere refere);
      public List<Commentaire> findByArticle(Article article);

}
