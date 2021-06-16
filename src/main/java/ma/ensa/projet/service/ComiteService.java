package ma.ensa.projet.service;

import ma.ensa.projet.domain.Article;
import ma.ensa.projet.domain.Commentaire;
import ma.ensa.projet.domain.Refere;

import java.util.List;

public interface ComiteService {
    public Commentaire affectArticleToRefere(Long id,Refere refere);
    public Article qualifier(Article article, Long id);
    public boolean politique(Article article,Long id);

}
