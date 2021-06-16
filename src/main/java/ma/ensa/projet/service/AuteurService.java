package ma.ensa.projet.service;

import ma.ensa.projet.domain.Auteur;

import java.util.List;
import java.util.Optional;

public interface AuteurService {
    public List<Auteur> findAll();
    public Optional<Auteur> findById(Long id);
    public Auteur save(Auteur auteur);
    public void delete(Auteur auteur);
    public void deleteById(Long id);

}
