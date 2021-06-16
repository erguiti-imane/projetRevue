package ma.ensa.projet.repository;

import ma.ensa.projet.domain.Article;
import ma.ensa.projet.domain.Auteur;
import ma.ensa.projet.domain.AuteurCorr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ArticleRepository extends JpaRepository<Article, Long> {
   public List<Article> findByAut(AuteurCorr auteurCorr);
   public List<Article> findByEtat(String etat);

}
