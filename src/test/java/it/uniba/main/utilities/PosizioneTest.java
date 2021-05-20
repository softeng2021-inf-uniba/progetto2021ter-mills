package it.uniba.main.utilities;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PosizioneTest {

    private Posizione posizione;

    @Before
    public void setUpPosizione() {
        posizione = new Posizione(1,1);
    }

    @Test
    public void testDifferenza() {
        Posizione pos1 = new Posizione(0,0);
        Posizione pos2 = new Posizione(1,1);
        Posizione result = new Posizione(-1,-1);
        assertEquals(result, Posizione.differenza(pos1,pos2));
    }

    @Test
    public void testEquals() {
        Posizione pos1 = new Posizione(0,0);
        Posizione pos2 = new Posizione(0,0);
        assertEquals(pos1, pos2);
    }

    @Test
    public void testHashCode() {
        assertEquals(993, posizione.hashCode());
    }
}
