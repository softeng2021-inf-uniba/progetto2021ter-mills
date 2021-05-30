package it.uniba.gioco.damiera;

import it.uniba.utilities.Posizione;
import org.junit.Before;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DamieraTest
{
    private Damiera damiera;

    @Before
    public void setUpDamiera()
    {
        damiera = new Damiera(8);
    }

    @Test
    public void testIsPosizioneValida()
    {
        assertTrue(damiera.isPosizioneValida(new Posizione(1,1)));
    }

    @Test
    public void testIsPedinaValida()
    {
        assertTrue(damiera.isPedinaValida(new Pedina(TipoPedina.bianca, new Posizione(1,1)), true));
    }

    @Test
    public void testGetPedina()
    {
        Posizione posizione = new Posizione(0,0);
        Pedina pedina = damiera.getPedina(posizione);
        assertTrue(pedina != null && posizione.equals(pedina.getPosizione()));
    }

    @Test
    public void testTrySpostamentoSemplice()
    {
        Posizione partenza = new Posizione(2,0);
        Posizione arrivo = new Posizione(3,1);
        Pedina pedina = damiera.getPedina(partenza);
        assertTrue(damiera.trySpostamentoSemplice(pedina, arrivo));
    }

    @Test
    public void testTryPresa()
    {
        Pedina pedinaBianca = damiera.getPedina(new Posizione(5,1));
        Pedina pedinaNera = damiera.getPedina(new Posizione(2,4));

        damiera.trySpostamentoSemplice(pedinaBianca, new Posizione(4,2));
        damiera.trySpostamentoSemplice(pedinaNera, new Posizione(3,3));

        List<Posizione> posList = new ArrayList<>();
        posList.add(pedinaBianca.getPosizione());
        posList.add(new Posizione(2,4));

        List<Pedina> listaPedine = new ArrayList<>();
        listaPedine.add(pedinaNera);

        assertEquals(listaPedine, damiera.tryPresa(posList));

        listaPedine.clear();
        posList.clear();

        posList.add(pedinaBianca.getPosizione());
        posList.add(new Posizione(1,1));

        assertEquals(listaPedine, damiera.tryPresa(posList));
    }

    @Test
    public void testSetPosizionePedinaDama()
    {
        Pedina pedinaBianca1 = damiera.getPedina(new Posizione(5,1));
        Pedina pedinaBianca2 = damiera.getPedina(new Posizione(6,2));
        Pedina pedinaBianca3 = damiera.getPedina(new Posizione(5,7));
        Pedina pedinaBianca4 = damiera.getPedina(new Posizione(5,5));
        Pedina pedinaBianca5 = damiera.getPedina(new Posizione(7,3));

        Pedina pedinaNera1 = damiera.getPedina(new Posizione(2,4));
        Pedina pedinaNera2 = damiera.getPedina(new Posizione(2,6));
        Pedina pedinaNera3 = damiera.getPedina(new Posizione(1,7));
        Pedina pedinaNera4 = damiera.getPedina(new Posizione(0,6));
        Pedina pedinaNera5 = damiera.getPedina(new Posizione(0,4));

        damiera.trySpostamentoSemplice(pedinaBianca1, new Posizione(4,2));
        damiera.trySpostamentoSemplice(pedinaNera1, new Posizione(3,3));

        damiera.trySpostamentoSemplice(pedinaBianca2, new Posizione(5,1));
        damiera.trySpostamentoSemplice(pedinaNera2, new Posizione(3,7));

        damiera.trySpostamentoSemplice(pedinaBianca3, new Posizione(4,6));
        damiera.trySpostamentoSemplice(pedinaNera3, new Posizione(2,6));

        damiera.trySpostamentoSemplice(pedinaBianca3, new Posizione(3,5));
        damiera.trySpostamentoSemplice(pedinaNera4, new Posizione(1,7));

        List<Posizione> posList = new ArrayList<>();
        posList.add(new Posizione(4,2));
        posList.add(new Posizione(2,4));
        posList.add(new Posizione(0,6));

        List<Pedina> listaPedine = new ArrayList<>();
        listaPedine.add(pedinaNera1);
        listaPedine.add(damiera.getPedina(new Posizione(1,5)));

        assertEquals(listaPedine, damiera.tryPresa(posList));

        damiera.trySpostamentoSemplice(pedinaNera5, new Posizione(1,5));
        damiera.trySpostamentoSemplice(pedinaBianca4, new Posizione(4,6));

        posList.clear();
        posList.add(new Posizione(3,7));
        posList.add(new Posizione(5,5));

        damiera.tryPresa(posList);
        damiera.trySpostamentoSemplice(pedinaBianca5, new Posizione(6,2));

        posList.clear();
        posList.add(new Posizione(5,5));
        posList.add(new Posizione(7,3));

        listaPedine.clear();
        listaPedine.add(damiera.getPedina(new Posizione(6,4)));

        assertEquals(listaPedine, damiera.tryPresa(posList));
    }

    @Test
    public void tryToString()
    {
        String str = "\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\n" +
                "\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\n" +
                "\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\n" +
                "\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u2003 \u001B[0m\n" +
                "\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\n" +
                "\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\n" +
                "\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\n" +
                "\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\n";
        assertEquals(str, damiera.toString());
    }
}
