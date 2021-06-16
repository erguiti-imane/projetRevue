package ma.ensa.projet.service.Impl;

import ma.ensa.projet.domain.Article;
import ma.ensa.projet.domain.Commentaire;
import ma.ensa.projet.domain.Refere;
import ma.ensa.projet.repository.ArticleRepository;
import ma.ensa.projet.repository.RefereRepository;
import ma.ensa.projet.service.RefereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RefereServiceImpl implements RefereService {
    @Autowired
    private RefereRepository refereRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public List<Refere> findAll() {
        return refereRepository.findAll();
    }





}
