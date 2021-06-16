package ma.ensa.projet.service;

import ma.ensa.projet.domain.Article;
import ma.ensa.projet.domain.Auteur;
import ma.ensa.projet.domain.AuteurCorr;
import ma.ensa.projet.domain.Revue;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    Article save(Article article);
    List<Article> findAll();
    List<Article> findByStateAttente();
    Optional<Article> findOne(Long id);
    List<Article> findByAuteurCorr(AuteurCorr auteurCorr);
    List<Article> findByAuteurPublished(AuteurCorr auteurCorr);
    List<Article> findByAuteurWithoutContent(AuteurCorr auteur);
    void delete(Long id);
    void delete(Article article);
    List<Article> findByEtat(String etat);
    public List<Article> findByKeyWord(String word);
    public List<Article> findByKeyWordWithoutContent(String word);
    public List<Article> findByKeyWordPublished(String word);
    public List<Article> findByKeyWordPubWith(String word);
    public List<Article> findAllPublished();
    public List<Article> findPublishedWithoutContent();
    public String suivreEtat(Article article);

}
