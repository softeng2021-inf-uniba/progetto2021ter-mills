package it.uniba.main.gioco.damiera;

import it.uniba.main.gioco.damiera.Pedina;
import it.uniba.main.gioco.damiera.TipoPedina;
import it.uniba.main.utilities.Posizione;
import it.uniba.main.utilities.Strings;
import org.junit.*;

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
        assertEquals(pedinaBianca.getTipo(), TipoPedina.bianca);
    }

    @Test
    public void testGetTipoPedinaNera()
    {
        assertEquals(pedinaNera.getTipo(), TipoPedina.nera);
    }

    @Test
    public void testGetDirezionePedinaBianca()
    {
        int direzione = -1;
        assertEquals(pedinaBianca.getDirezione(), direzione);
    }

    @Test
    public void testGetDirezionePedinaNera()
    {
        int direzione = 1;
        assertEquals(pedinaNera.getDirezione(), direzione);
    }

    @Test
    public void testToStringPedinaBianca()
    {
        assertEquals(pedinaBianca.toString(), Strings.PEDINA_BIANCA);
    }

    @Test
    public void testToStringPedinaNera()
    {
        assertEquals(pedinaNera.toString(), Strings.PEDINA_NERA);
    }

    @Test
    public void testToStringPedinaBiancaRegina()
    {
        pedinaBianca.isDama = true;
        assertEquals(pedinaBianca.toString(), Strings.PEDINA_REGINA_BIANCA);
    }

    @Test
    public void testToStringPedinaNeraRegina()
    {
        pedinaNera.isDama = true;
        assertEquals(pedinaNera.toString(), Strings.PEDINA_REGINA_NERA);
    }

}
