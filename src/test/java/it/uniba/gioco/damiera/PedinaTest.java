package it.uniba.gioco.damiera;

import it.uniba.utilities.Posizione;
import it.uniba.utilities.Strings;
import org.junit.*;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class PedinaTest
{
    private Pedina pedinaBianca;
    private Pedina pedinaNera;

    @Before
    public void setUpPedina()
    {
        pedinaBianca = new Pedina(TipoPedina.bianca, new Posizione(7,7));
        pedinaNera = new Pedina(TipoPedina.nera, new Posizione(0,0));
    }

    @Test
    public void testGetTipoPedinaBianca()
    {
        assertEquals(TipoPedina.bianca, pedinaBianca.getTipo());
    }

    @Test
    public void testGetTipoPedinaNera()
    {
        assertEquals(TipoPedina.nera, pedinaNera.getTipo());
    }

    @Test
    public void testGetDirezionePedinaBianca()
    {
        int direzione = -1;
        assertEquals(direzione, pedinaBianca.getDirezione());
    }

    @Test
    public void testGetDirezionePedinaNera()
    {
        int direzione = 1;
        assertEquals(direzione, pedinaNera.getDirezione());
    }

    @Test
    public void testToStringPedinaBianca()
    {
        Assertions.assertEquals(Strings.PEDINA_BIANCA, pedinaBianca.toString());
    }

    @Test
    public void testToStringPedinaNera()
    {
        assertEquals(Strings.PEDINA_NERA, pedinaNera.toString());
    }

    @Test
    public void testToStringPedinaBiancaRegina()
    {
        pedinaBianca.setDama(true);
        assertEquals(Strings.PEDINA_REGINA_BIANCA, pedinaBianca.toString());
    }

    @Test
    public void testToStringPedinaNeraRegina()
    {
        pedinaNera.setDama(true);
        assertEquals(Strings.PEDINA_REGINA_NERA, pedinaNera.toString());
    }

}
