package ma.ensa.projet.repository;

import ma.ensa.projet.domain.Revue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevueRepository extends JpaRepository<Revue,Long> {
}
