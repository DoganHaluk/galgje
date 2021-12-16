package be.vdab.galgje.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorieen")
public class Categorie {
    @Id
    private long id;
    private String naam;
    @ElementCollection
    @CollectionTable(name = "woorden", joinColumns = @JoinColumn(name = "categorieid"))
    private List<Woord> woorden;

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public List<Woord> getWoorden() {
        return woorden;
    }
}
