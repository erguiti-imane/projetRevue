package ma.ensa.projet.service.Impl;

import ma.ensa.projet.domain.Article;
import ma.ensa.projet.domain.Commentaire;
import ma.ensa.projet.domain.Refere;
import ma.ensa.projet.repository.ArticleRepository;
import ma.ensa.projet.service.ArticleService;
import ma.ensa.projet.service.ComiteService;
import ma.ensa.projet.service.CommentaireService;
import ma.ensa.projet.service.RefereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ComiteServiceImpl implements ComiteService {
    @Autowired
    private RefereService refereService;
    @Autowired
    private CommentaireService commentaireService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public Commentaire affectArticleToRefere(Long id,Refere refere) {
      Commentaire commentaire=new Commentaire();
      commentaire.setArticle(articleService.findOne(id).get());
      commentaire.setRefere(refere);
      Commentaire commentaire1=commentaireService.save(commentaire);
        return commentaire1;
    }
    @Override
    public Article qualifier(Article article, Long id) {
        Article a=this.articleRepository.findById(id).get();
        List<Commentaire> commentaires=a.getCommentaires();
        for(Commentaire commentaire:commentaires){
            if(!commentaire.getQualification().isEmpty()){
                a.setEtat(article.getEtat());
            }
        }
        return articleRepository.save(a);
    }

    @Override
    public boolean politique(Article article,Long id) {
        Article a=this.articleRepository.findById(id).get();
        a.setPolitique(article.isPolitique());
        articleRepository.save(a);
        return article.isPolitique();
    }
}
