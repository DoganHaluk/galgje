package be.vdab.galgje.services;

import be.vdab.galgje.domain.Categorie;
import be.vdab.galgje.domain.Woord;

import java.util.List;
import java.util.Optional;

public interface CategorieService {
    List<Categorie> findAll();

    Optional<Categorie> findById(long id);


}
