package it.uniba.main.utilities;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class UtilitiesTest
{
    @Test
    public void testConvertiPosizione()
    {
        Posizione posAspettata = new Posizione(0,0);
        assertEquals(posAspettata, Utilities.convertiPosizione(1, 8));
    }

    @Test
    public void testPulisciStringa()
    {
        String str = " pippo ";
        String strTrim = "pippo";
        assertEquals(strTrim, Utilities.pulisciStringa(str));
    }

    @Test
    public void testGetStringaTempo()
    {
        String tmp = "00:01";
        assertEquals(tmp, Utilities.getStringaTempo(1000));
    }



}
