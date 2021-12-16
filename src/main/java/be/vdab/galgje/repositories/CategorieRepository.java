package be.vdab.galgje.repositories;

import be.vdab.galgje.domain.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {}
