package be.vdab.galgje.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Access(AccessType.FIELD)
public class Woord {
    private String woord;

    protected Woord() {

    }

    public String getWoord() {
        return woord;
    }

    public Woord(String woord) {
        this.woord = woord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Woord)) return false;
        Woord woord1 = (Woord) o;
        return Objects.equals(woord, woord1.woord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(woord);
    }
}
