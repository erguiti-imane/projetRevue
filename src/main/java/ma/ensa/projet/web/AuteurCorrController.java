package ma.ensa.projet.web;

import ma.ensa.projet.domain.Article;
import ma.ensa.projet.domain.AuteurCorr;
import ma.ensa.projet.domain.Commentaire;
import ma.ensa.projet.service.ArticleService;
import ma.ensa.projet.service.AuteurCorrService;
import ma.ensa.projet.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auteur")
public class AuteurCorrController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private AuteurCorrService auteurCorrService;
    @Autowired
    private CommentaireService commentaireService;

    @GetMapping("/articles")
    public ResponseEntity<Iterable<Article>> getAllPublished(){
        Iterable<Article> result=articleService.findAllPublished();
        return new ResponseEntity<Iterable<Article>>(result, HttpStatus.OK);
    }
    @GetMapping("/article/{id}")
    public Optional<Article> getArticle(@PathVariable Long id){
        Optional<Article> result=articleService.findOne(id);
        return result;
    }
    @GetMapping("/articlesByAut")
    public List<Article> findByAutCorr(@RequestBody AuteurCorr auteurCorr){
        return articleService.findByAuteurCorr(auteurCorr);
    }
    @PutMapping("/update/{id}")
    public Article updateArticle(@RequestBody Article newArticle,@PathVariable Long id){
        return auteurCorrService.updateArticle(newArticle,id);
    }
    @DeleteMapping("/deleteArticle")
    public void deleteArticle(@RequestBody Article article){
        articleService.delete(article);
    }

    @GetMapping("/EtatArticle")
    public String suivreEtat(@RequestBody Article article){
        return articleService.suivreEtat(article);
    }

    @GetMapping("/commentaires")
    public List<Commentaire> getComments(@RequestBody Article article){
        return this.commentaireService.findByArticle(article);
    }
    @GetMapping("/auteurs")
    public List<AuteurCorr> getAuteurs(){
        return auteurCorrService.findAll();
    }
    @GetMapping("/{word}")
    public List<Article> getPublishedArticleByKeyWord(@PathVariable String word){
        return articleService.findByKeyWordPubWith(word);
    }

}
