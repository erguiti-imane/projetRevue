package ma.ensa.projet.service;

import ma.ensa.projet.domain.Article;
import ma.ensa.projet.domain.Auteur;
import ma.ensa.projet.domain.AuteurCorr;

import java.util.List;
import java.util.Optional;

public interface AuteurCorrService {
    public List<AuteurCorr> findAll();
    public Optional<AuteurCorr> findById(Long id);
    public AuteurCorr save(AuteurCorr auteurCorr);
    public void delete(AuteurCorr auteurCorr);
    public void deleteById(Long id);
    public Article updateArticle(Article article,Long id);
    public void logModification(Article first,Article second);
}
