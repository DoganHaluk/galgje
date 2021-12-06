package be.vdab.galgje.repositories;

import be.vdab.galgje.domain.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    List<Categorie> findAll();

    Optional<Categorie> findById(long id);
}
