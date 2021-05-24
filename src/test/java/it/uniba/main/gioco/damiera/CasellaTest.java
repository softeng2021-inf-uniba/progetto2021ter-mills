package it.uniba.main.gioco.damiera;

import it.uniba.main.utilities.Posizione;
import it.uniba.main.utilities.Strings;
import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

public class CasellaTest {
    private Casella casellaNera;
    private Casella casellaBianca;
    private Pedina pedina;

    @Before
    public void setUpCasella() {
        casellaNera = new Casella(TipoCasella.nera);
        casellaBianca = new Casella(TipoCasella.bianca);
        pedina = new Pedina(TipoPedina.nera, new Posizione(0, 0));
        casellaNera.setPedina(pedina);
    }

    @Test
    public void testGetPedina() {
        assertEquals(pedina, casellaNera.getPedina());
    }

    @Test
    public void testToStringCasellaBiancaVuota() {
        String result = Strings.RGB_CREMA_BG + " " + Strings.CASELLA_VUOTA + " " + Strings.ANSI_RESET;
        assertEquals(result, casellaBianca.toString());
    }

    @Test
    public void testToStringCasellaNeraPiena() {
        String result = Strings.RGB_INDACO_BG + " " + pedina.toString() + " " + Strings.ANSI_RESET;
        assertEquals(result, casellaNera.toString());
    }

    @Test
    public void testSetTipoCasella() {
        String result = Strings.RGB_CREMA_BG + " " + Strings.CASELLA_VUOTA + " " + Strings.ANSI_RESET;
        assertEquals(result, casellaBianca.toString());

        casellaBianca.setTipoCasella(TipoCasella.nera);

        result = Strings.RGB_INDACO_BG + " " + Strings.CASELLA_VUOTA + " " + Strings.ANSI_RESET;
        assertEquals(result, casellaBianca.toString());
    }
}
