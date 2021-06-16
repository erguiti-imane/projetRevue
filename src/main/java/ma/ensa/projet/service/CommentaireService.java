package ma.ensa.projet.service;

import ma.ensa.projet.domain.Article;
import ma.ensa.projet.domain.AuteurCorr;
import ma.ensa.projet.domain.Commentaire;
import ma.ensa.projet.domain.Refere;

import java.util.List;

public interface CommentaireService {
    public List<Commentaire> findByRefere(Refere refere);
    public List<Commentaire> findByAuteur(AuteurCorr auteurCorr);
    public List<Commentaire> findByArticle(Article article);
    public Commentaire save(Commentaire commentaire);
    public List<Commentaire> findAll();
    public boolean saveComment(Commentaire commentaire,String comment,String qualification);
}
