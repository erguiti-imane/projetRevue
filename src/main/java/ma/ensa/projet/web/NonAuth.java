package ma.ensa.projet.web;

import ma.ensa.projet.domain.Article;
import ma.ensa.projet.domain.AuteurCorr;
import ma.ensa.projet.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nonAuth/article")
public class NonAuth {

    @Autowired
    ArticleService articleService;
    @GetMapping("")
  public List<Article> getArticlesNonAuth(){
      return articleService.findPublishedWithoutContent();
  }
    @GetMapping("/articlesByAut")
    public List<Article> findByAutCorr(@RequestBody AuteurCorr auteurCorr){
        return articleService.findByAuteurWithoutContent(auteurCorr);
    }
    @GetMapping("/{word}")
    public List<Article> getPublishedArticleByKeyWord(@PathVariable String word){
        return articleService.findByKeyWordWithoutContent(word);
    }

}
