package ma.ensa.projet.repository;

import ma.ensa.projet.domain.Article;
import ma.ensa.projet.domain.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Long> {
}
