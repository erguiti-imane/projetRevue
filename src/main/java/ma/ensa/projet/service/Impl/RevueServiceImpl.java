package ma.ensa.projet.service.Impl;

import ma.ensa.projet.domain.Revue;
import ma.ensa.projet.repository.RevueRepository;
import ma.ensa.projet.service.RevueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RevueServiceImpl implements RevueService {
    @Autowired
    RevueRepository revueRepository;
    @Override
    public List<Revue> findAll() {
        return revueRepository.findAll();
    }
}
