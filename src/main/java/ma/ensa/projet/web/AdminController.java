package ma.ensa.projet.web;

import ma.ensa.projet.domain.*;
import ma.ensa.projet.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private  final ArticleService articleService;
    private  final AuteurCorrService auteurService;
    @Autowired
    private final CommentaireService commentaireService;
    @Autowired
    private final RefereService refereService;
    private final ComiteService comiteService;
    @Autowired
    private final RevueService revueService;
    public AdminController(ArticleService articleService, AuteurCorrService auteurService, CommentaireService commentaireService, RefereService refereService, ComiteService comiteService, RevueService revueService) {
        this.articleService = articleService;
        this.auteurService = auteurService;
        this.commentaireService = commentaireService;
        this.refereService = refereService;

        this.comiteService = comiteService;
        this.revueService = revueService;
    }
    @GetMapping("/revues")
    public List<Revue> findAllRevues(){
     return revueService.findAll();
    }
    @PostMapping("/article")
    public Article createArticle(@RequestBody Article article){

        Article result=articleService.save(article);

        return result;
    }
    @GetMapping("/articleAttente")
    public List<Article> getAttenteArticle(){
        return articleService.findByStateAttente();
    }

    @GetMapping("/article/rapport")
    public List<Commentaire> getRapportsByArticle(@RequestBody Article article){
        return commentaireService.findByArticle(article);
    }
    @GetMapping("article/rapports")
    public List<Commentaire> getAllRapports(){
        return commentaireService.findAll();
    }
    @RequestMapping(value="/referes", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Refere>>  getAllReferes(){
        Iterable<Refere> refere= (Iterable<Refere>) refereService.findAll();
        return new ResponseEntity<Iterable<Refere>>(refere,HttpStatus.OK);
    }
    @GetMapping("/articles")
    public ResponseEntity<Iterable<Article>> getAll(){
        Iterable<Article> result= (Iterable<Article>) articleService.findAll();
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
    @GetMapping("/EtatArticle")
    public String suivreEtat(@RequestBody Article article){
        return articleService.suivreEtat(article);
    }

    @GetMapping("/affecter/{id}")
    public  Commentaire affecterArticleToRefere(@PathVariable Long id,@RequestBody Refere refere){
        return  this.comiteService.affectArticleToRefere(id,refere);
    }
    @GetMapping("/commentaires")
    public List<Commentaire> findAllComment(){
        return commentaireService.findAll();
    }
    @GetMapping("/auteursCorr")
    public List<AuteurCorr> findAllAuteurs(){
        return auteurService.findAll();
    }
    @PutMapping("/qualifier/{id}")
    public Article qualifier(@RequestBody Article newArticle,@PathVariable Long id){
        return comiteService.qualifier(newArticle,id);
    }
   @PutMapping("/politique/{id}")
    public boolean politique(@RequestBody Article newArticle, @PathVariable Long id){
        return comiteService.politique(newArticle,id);
   }
}
