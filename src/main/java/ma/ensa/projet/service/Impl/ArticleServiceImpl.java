package ma.ensa.projet.service.Impl;

import ma.ensa.projet.domain.Article;
import ma.ensa.projet.domain.AuteurCorr;
import ma.ensa.projet.domain.Commentaire;
import ma.ensa.projet.domain.Revue;
import ma.ensa.projet.repository.ArticleRepository;
import ma.ensa.projet.repository.RevueRepository;
import ma.ensa.projet.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
 private final ArticleRepository articleRepository;
    @Autowired
 private final RevueRepository revueRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, RevueRepository revueRepository) {
        this.articleRepository = articleRepository;
        this.revueRepository = revueRepository;
    }

    @Override
    public Article save(Article article) {

        return articleRepository.save(article);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> findByStateAttente() {
        return articleRepository.findByEtat("en attente");
    }

    @Override
    public Optional<Article> findOne(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public List<Article> findByAuteurCorr(AuteurCorr auteurCorr) {
        return articleRepository.findByAut(auteurCorr);
    }

    @Override
    public List<Article> findByAuteurPublished(AuteurCorr auteurCorr) {

        List<Article> articles=this.findByAuteurCorr(auteurCorr);
        List<Article> published=new ArrayList<>();
        for(Article article:articles) {
            if(article.getEtat().equals("published")) {
                published.add(article);
            }
        }
        return published;
    }

    @Override
    public List<Article> findByAuteurWithoutContent(AuteurCorr auteurCorr) {
        List<Article> articles=this.findByAuteurPublished(auteurCorr);
        List<Article> withoutContent=new ArrayList<>();
        for(Article article:articles) {
            article.setContenu(null);
            withoutContent.add(article);
        }
        return withoutContent;
    }


    @Override
    public void delete(Long id)
    {
articleRepository.deleteById(id);
    }

    @Override
    public void delete(Article article) {
        if(article.getEtat().equals("en attente")){
            articleRepository.delete(article);
        }else System.out.println("PROCESS COMMENCE");
    }

    @Override
    public List<Article> findByEtat(String etat) {
      return  articleRepository.findByEtat(etat);
    }


    @Override
    public List<Article> findByKeyWord(String mot) {
        List<Article> articles=articleRepository.findAll();
        List<Article> byKeyWord=new ArrayList<>();
        if(!articles.isEmpty()){
            for(Article article:articles){
                for (String k: article.getMotCles()){
                    if(k.equals(mot)){
                        byKeyWord.add(article);
                        break;
                    }
                }
            }
        }
        return byKeyWord;
    }

    @Override
    public List<Article> findByKeyWordWithoutContent(String mot) {
        List<Article> articles=this.findByKeyWord(mot);
        List<Article> withoutContent=new ArrayList<>();
        for (Article article:articles){
            article.setContenu(null);
            withoutContent.add(article);
        }
        return withoutContent;
    }

    @Override
    public List<Article> findByKeyWordPublished(String mot) {
        List<Article> articles=this.findByKeyWordWithoutContent(mot);
        List<Article> published=new ArrayList<>();
        for (Article article:articles){
           if (article.getEtat().equals("published")){
               published.add(article);
           }

        }
        return published;

    }

    @Override
    public List<Article> findByKeyWordPubWith(String word) {
        List<Article> articles=this.findByKeyWord(word);
        List<Article> published=new ArrayList<>();
        for (Article article:articles){
            if (article.getEtat().equals("published")){
                published.add(article);
            }

        }
        return published;
    }


    @Override
    public List<Article> findAllPublished() {
        List<Article> articles=this.findAll();
        List<Article> published=new ArrayList<>();
        for(Article article:articles){
            if(article.getEtat().equals("published")){
                published.add(article);
            }
        }

        return published;
    }

    @Override
    public List<Article> findPublishedWithoutContent() {
        List<Article> articles=this.findAllPublished();
        List<Article> withoutContent=new ArrayList<>();
        for (Article article:articles){
            article.setContenu(null);
            withoutContent.add(article);
        }
        return withoutContent;
    }

    @Override
    public String suivreEtat(Article article) {
        return article.getEtat();
    }




}
