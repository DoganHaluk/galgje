package be.vdab.galgje.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

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
}
