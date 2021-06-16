package ma.ensa.projet.repository;

import ma.ensa.projet.domain.Article;
import ma.ensa.projet.domain.Refere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefereRepository extends JpaRepository<Refere, Long> {
}
