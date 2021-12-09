package be.vdab.galgje.sessions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaadHetWoordTest {
    private RaadHetWoord raadHetWoord;

    @BeforeEach
    void beforeEach() {
        raadHetWoord = new RaadHetWoord();
        raadHetWoord.reset("lol");
    }

    @Test
    void eenNieuwSpel() {
        assertThat(raadHetWoord.getWoord()).isEqualTo("lol");
        assertThat(raadHetWoord.getPuntjes()).isEqualTo("---");
        assertThat(raadHetWoord.getVerkeerdePogingen()).isZero();
        assertThat(raadHetWoord.isGewonnen()).isFalse();
        assertThat(raadHetWoord.isVerloren()).isFalse();
    }

    @Test
    void eenJuisteLetterRaden() {
        raadHetWoord.gok('l');
        assertThat(raadHetWoord.getPuntjes()).isEqualTo("l-l");
        assertThat(raadHetWoord.getVerkeerdePogingen()).isZero();
        assertThat(raadHetWoord.isGewonnen()).isFalse();
        assertThat(raadHetWoord.isVerloren()).isFalse();
    }

    @Test
    void eenVerkeerdeLetterRaden() {
        raadHetWoord.gok('z');
        assertThat(raadHetWoord.getPuntjes()).isEqualTo("---");
        assertThat(raadHetWoord.getVerkeerdePogingen()).isOne();
        assertThat(raadHetWoord.isGewonnen()).isFalse();
        assertThat(raadHetWoord.isVerloren()).isFalse();
    }

    @Test
    void deVolledigeWoordRaden() {
        raadHetWoord.gok('l');
        raadHetWoord.gok('o');
        assertThat(raadHetWoord.isGewonnen()).isTrue();
        assertThat(raadHetWoord.isVerloren()).isFalse();
    }

    @Test
    void jeVerliestBijTeVeelPogingen() {
        for (var poging = 1; poging <= 10; poging++) {
            raadHetWoord.gok('a');
        }
        assertThat(raadHetWoord.isGewonnen()).isFalse();
        assertThat(raadHetWoord.isVerloren()).isTrue();
    }
}
