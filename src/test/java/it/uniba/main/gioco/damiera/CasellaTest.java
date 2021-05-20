package it.uniba.main.gioco.damiera;

import it.uniba.main.utilities.Posizione;
import it.uniba.main.utilities.Strings;
import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

public class CasellaTest
{
    private static Casella casellaNera;
    private static Casella casellaBianca;
    private static Pedina pedina;

    @BeforeClass
    public static void setUpCasella()
    {
        casellaNera = new Casella(TipoCasella.nera);
        casellaBianca = new Casella(TipoCasella.bianca);
        pedina = new Pedina(TipoPedina.nera, new Posizione(0,0));
        casellaNera.setPedina(pedina);
    }

    @Test
    public void testGetPedina()
    {
        assertEquals(casellaNera.getPedina(), pedina);
    }

    @Test
    public void toStringCasellaBiancaVuota()
    {
        String result = Strings.RGB_CREMA_BG + " " + Strings.CASELLA_VUOTA + " " + Strings.ANSI_RESET;
        assertEquals(casellaBianca.toString(), result);
    }

    @Test
    public void toStringCasellaNeraPiena()
    {
        String result = Strings.RGB_INDACO_BG + " " + pedina.toString() + " " + Strings.ANSI_RESET;
        assertEquals(casellaNera.toString(), result);
    }
}
