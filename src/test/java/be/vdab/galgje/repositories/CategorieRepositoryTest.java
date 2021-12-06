package be.vdab.galgje.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(showSql = false)
@Sql("/insertCategorieen.sql")
public class CategorieRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final String CATEGORIEEN = "categorieen";
    private final CategorieRepository repository;

    CategorieRepositoryTest(CategorieRepository repository) {
        this.repository = repository;
    }

    private long idVanTestCategorie() {
        return jdbcTemplate.queryForObject("select id from categorieen where naam='test'", Long.class);
    }

    @Test
    void findAll() {
        assertThat(repository.findAll())
                .hasSize(countRowsInTable(CATEGORIEEN));
    }

    @Test
    void findById() {
        assertThat(repository.findById(idVanTestCategorie()))
                .hasValueSatisfying(categorie -> assertThat(categorie.getNaam()).isEqualTo("test"));
    }
}