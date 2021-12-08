package be.vdab.galgje.services;

import be.vdab.galgje.domain.Categorie;
import be.vdab.galgje.repositories.CategorieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultCategorieService implements CategorieService {
    private final CategorieRepository categorieRepository;

    public DefaultCategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Categorie> findById(long id) {
        return categorieRepository.findById(id);
    }
}
