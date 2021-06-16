package ma.ensa.projet.service.Impl;

import ma.ensa.projet.domain.Article;
import ma.ensa.projet.domain.AuteurCorr;
import ma.ensa.projet.repository.ArticleRepository;
import ma.ensa.projet.repository.AuteurCorrRepository;
import ma.ensa.projet.service.AuteurCorrService;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.SimpleLayout;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import java.util.List;
import java.util.Optional;
import java.util.logging.SimpleFormatter;

@Service
@Transactional
public class AuteurCorrServiceImpl implements AuteurCorrService {
    private final AuteurCorrRepository auteurRepository;
    private final ArticleRepository articleRepository;

    public AuteurCorrServiceImpl(AuteurCorrRepository auteurRepository, ArticleRepository articleRepository) {
        this.auteurRepository = auteurRepository;
        this.articleRepository = articleRepository;
    }



    @Override
    public List<AuteurCorr> findAll()
    {
        return auteurRepository.findAll();
    }

    @Override
    public Optional<AuteurCorr> findById(Long id) {
        return auteurRepository.findById(id);
    }

    @Override
    public AuteurCorr save(AuteurCorr auteurCorr) {
        return auteurRepository.save(auteurCorr);
    }

    @Override
    public void delete(AuteurCorr auteurCorr) {
        auteurRepository.delete(auteurCorr);
    }

    @Override
    public void deleteById(Long id) {
auteurRepository.deleteById(id);
    }

    @Override
    public Article updateArticle(Article article, Long id) {
        Article a=this.articleRepository.findById(id).get();
        this.logModification(a,article);

        if(a.getEtat().equals("en attente")) {

            a.setContenu(article.getContenu());


           a.setResume(article.getResume());

           a.setTitre(article.getTitre());
        }
        return articleRepository.save(a);
    }

    @Override
    public void logModification(Article first, Article second) {

        Logger log = Logger.getLogger("Log");
        SimpleFormatter formatter = new SimpleFormatter();
        try {
            FileHandler fileHandler=new FileHandler("C:\\Users\\asus\\Desktop\\ProjetSpring\\log.log");
            log.addHandler(fileHandler);
            fileHandler.setFormatter(formatter);
            String titleMessage="ancien Titre: "+first.getTitre()+"** nouveau Titre: "+second.getTitre();
            String contentMessage="ancien Contenu : "+first.getContenu()+" **** "+"nouveau Contenu : "+second.getContenu();
            String resumeMessage="ancien Resume : "+first.getResume()+" **** "+"nouveau Resume : "+second.getResume();
 log.info(titleMessage);
 log.info(contentMessage);
 log.info(resumeMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}
