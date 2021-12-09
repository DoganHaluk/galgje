package be.vdab.galgje.sessions;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

@Component
@SessionScope
public class RaadHetWoord implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final int MAX_VERKEERDE_POGINGEN = 10;
    private String woord;
    private StringBuilder puntjes = new StringBuilder();
    private int verkeerdePogingen;
    private Set<Character> letters = new TreeSet<>();

    public void reset(String woord) {
        this.woord = woord;
        puntjes = new StringBuilder("-".repeat(woord.length()));
        letters = new TreeSet<>();
        verkeerdePogingen = 0;
    }

    public void gok(char letter) {
        var letterIndex = woord.indexOf(letter);
        if (letterIndex == -1) {
            verkeerdePogingen++;
        } else {
            do {
                puntjes.setCharAt(letterIndex, letter);
                letterIndex = woord.indexOf(letter, letterIndex + 1);
            } while (letterIndex != -1);
        }
    }

    public String getPuntjes() {
        return puntjes.toString();
    }

    public String getWoord() {
        return woord;
    }

    public int getVerkeerdePogingen() {
        return verkeerdePogingen;
    }

    public boolean isGewonnen() {
        return puntjes.indexOf("-") == -1;
    }

    public boolean isVerloren() {
        return verkeerdePogingen == MAX_VERKEERDE_POGINGEN;
    }

    public void voegLetterToe(char letter) {
        letters.add(letter);
    }

    public Set<Character> getLetters() {
        return letters;
    }
}
