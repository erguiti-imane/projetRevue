package ma.ensa.projet.service.Impl;

import ma.ensa.projet.domain.Auteur;
import ma.ensa.projet.repository.AuteurRepository;
import ma.ensa.projet.service.AuteurService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuteurServiceImpl implements AuteurService {
   private AuteurRepository auteurRepository;
    @Override
    public List<Auteur> findAll() {
        return auteurRepository.findAll();
    }

    @Override
    public Optional<Auteur> findById(Long id) {
        return auteurRepository.findById(id);
    }

    @Override
    public Auteur save(Auteur auteur) {
        return auteurRepository.save(auteur);
    }

    @Override
    public void delete(Auteur auteur) {
      auteurRepository.delete(auteur);
    }

    @Override
    public void deleteById(Long id) {
      auteurRepository.deleteById(id);
    }
}
