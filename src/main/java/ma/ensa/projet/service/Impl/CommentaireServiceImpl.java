package ma.ensa.projet.service.Impl;

import ma.ensa.projet.domain.Article;
import ma.ensa.projet.domain.AuteurCorr;
import ma.ensa.projet.domain.Commentaire;
import ma.ensa.projet.domain.Refere;
import ma.ensa.projet.repository.CommentaireRepository;
import ma.ensa.projet.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CommentaireServiceImpl implements CommentaireService {
    @Autowired
    private CommentaireRepository commentaireRepository;
    @Override
    public List<Commentaire> findByRefere(Refere refere) {
        List<Commentaire> commentaires=commentaireRepository.findByRefere(refere);
        List<Commentaire> commentaires1=new ArrayList<>();
        for(Commentaire commentaire:commentaires){
            if(commentaire.getArticle().getEtat().equals("encours")){
                Article article=commentaire.getArticle();
                article.setAut(null);
                article.setAuteurs(null);
                commentaire.setArticle(article);
            }
            commentaires1.add(commentaire);
        }
        return commentaires1;

    }

    @Override
    public List<Commentaire> findByAuteur(AuteurCorr auteurCorr) {
        return null;
    }

    @Override
    public List<Commentaire> findByArticle(Article article) {
        List<Commentaire> commentaires=commentaireRepository.findByArticle(article);
        List<Commentaire> commentaires1=new ArrayList<>();
        for(Commentaire commentaire:commentaires){
            if(commentaire.getArticle().getEtat().equals("encours")){
                commentaire.setRefere(null);


            }
            commentaires1.add(commentaire);
        }
        return commentaires1;

    }

    @Override
    public Commentaire save(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public List<Commentaire> findAll() {
        return commentaireRepository.findAll();
    }

    @Override
    public boolean saveComment(Commentaire commentaire,String comment,String qualification) {
        Commentaire commentaire1=commentaireRepository.findById(commentaire.getId()).get();
        commentaire1.setCommentaire(comment);
        commentaire1.setQualification(qualification);
        commentaireRepository.save(commentaire1);
        return true;
    }


}
