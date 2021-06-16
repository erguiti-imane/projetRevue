package ma.ensa.projet.repository;

import ma.ensa.projet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);

}
