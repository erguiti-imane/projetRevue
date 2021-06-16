package ma.ensa.projet.web;

import ma.ensa.projet.domain.Article;
import ma.ensa.projet.domain.Commentaire;
import ma.ensa.projet.domain.Refere;
import ma.ensa.projet.service.CommentaireService;
import ma.ensa.projet.service.RefereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/refere")
public class RefereController {
    @Autowired
    RefereService refereService;
    @Autowired
    CommentaireService commentaireService;

    @GetMapping("/referes")
    public List<Refere> findAll(){
        return refereService.findAll();
    }
    @GetMapping("/rappsorts")
    public List<Commentaire> getAllRapports(@RequestBody Refere refere){
        return commentaireService.findByRefere(refere);
    }
    @PutMapping("/{comment}/{qualification}")
    public boolean evaluerArticle(@RequestBody Commentaire commentaire,@PathVariable String comment,@PathVariable String qualification){
        return commentaireService.saveComment(commentaire,comment,qualification);
    }

}
