package it.uniba.main.gioco;

import it.uniba.main.utilities.Strings;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest {
  @Test
  public void testController() {

    StringBuilder strAspettatas = new StringBuilder();
    StringBuilder strInseritas = new StringBuilder();
    strInseritas.append("damiera\n");
    strAspettatas.append(Strings.ERRORE_COMANDO_IN_GIOCO + "\r\n");
    strInseritas.append("pippo\n");
    strAspettatas.append(Strings.COMANDO_ERRATO +"\r\n");
    strInseritas.append("help\n");
    strAspettatas.append(Strings.HELP_MSG + "\r\n");
    strInseritas.append("numeri\n");
    String numeri = "\u001B[48;2;102;117;189m\u001B[30m1\u001B[48;2;102;117;189m\u001B[38;2;102;117;189m_ " +
        "\u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m\u001B" +
        "[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m2\u001B[48;2;102;117;189m\u001B[38;2;102;117;189m_ " +
        "\u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m\u001B" +
        "[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m3\u001B[48;2;102;117;189m\u001B[38;2;102;117;189m_ " +
        "\u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m\u001B" +
        "[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m4\u001B[48;2;102;117;189m\u001B[38;2;102;117;189m_ " +
        "\u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m\u001B" +
        "[38;2;255;255;202m_ \u001B[0m\n" +
        "\u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_" +
        "\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m5\u001B[48;2;102;117;189m" +
        "\u001B[38;2;102;117;189m_ \u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_" +
        "\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m6\u001B[48;2;102;117;189m" +
        "\u001B[38;2;102;117;189m_ \u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_" +
        "\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m7\u001B[48;2;102;117;189m" +
        "\u001B[38;2;102;117;189m_ \u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_" +
        "\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m8\u001B[48;2;102;117;189m" +
        "\u001B[38;2;102;117;189m_ \u001B[0m\n" +
        "\u001B[48;2;102;117;189m\u001B[30m9\u001B[48;2;102;117;189m" +
        "\u001B[38;2;102;117;189m_ \u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_" +
        "\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m10 " +
        "\u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m" +
        "\u001B[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m11 \u001B[48;2;255;255;202m\u001B[48;2;255;255;202m" +
        "\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ \u001B[48;2;102;117;189m" +
        "\u001B[30m12 \u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m" +
        "\u001B[38;2;255;255;202m_ \u001B[0m\n" +
        "\u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_" +
        "\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m13 \u001B[48;2;255;255;202m" +
        "\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ " +
        "\u001B[48;2;102;117;189m\u001B[30m14 \u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_" +
        "\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m15 \u001B[48;2;255;255;202m" +
        "\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ " +
        "\u001B[48;2;102;117;189m\u001B[30m16 \u001B[0m\n" +
        "\u001B[48;2;102;117;189m\u001B[30m17 \u001B[48;2;255;255;202m" +
        "\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ " +
        "\u001B[48;2;102;117;189m\u001B[30m18 \u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_" +
        "\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m19 \u001B[48;2;255;255;202m" +
        "\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ " +
        "\u001B[48;2;102;117;189m\u001B[30m20 \u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_" +
        "\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ \u001B[0m\n" +
        "\u001B[48;2;255;255;202m\u001B[48;2;255;255;202m" +
        "\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m21 " +
        "\u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m" +
        "\u001B[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m22 \u001B[48;2;255;255;202m\u001B[48;2;255;255;202m" +
        "\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m23 " +
        "\u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m" +
        "\u001B[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m24 \u001B[0m\n" +
        "\u001B[48;2;102;117;189m\u001B[30m25 " +
        "\u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ " +
        "\u001B[48;2;102;117;189m\u001B[30m26 \u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_" +
        "\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m27 \u001B[48;2;255;255;202m" +
        "\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ " +
        "\u001B[48;2;102;117;189m\u001B[30m28 \u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_" +
        "\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ \u001B[0m\n" +
        "\u001B[48;2;255;255;202m\u001B[48;2;255;255;202m" +
        "\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m29 " +
        "\u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ " +
        "\u001B[48;2;102;117;189m\u001B[30m30 \u001B[48;2;255;255;202m\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_" +
        "\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ \u001B[48;2;102;117;189m\u001B[30m31 \u001B[48;2;255;255;202m" +
        "\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_\u001B[48;2;255;255;202m\u001B[38;2;255;255;202m_ " +
        "\u001B[48;2;102;117;189m\u001B[30m32 \u001B[0m\n" +
        "\r\n";
    strAspettatas.append(numeri);
    strInseritas.append("gioca\n");
    strAspettatas.append(Strings.INIZIO_PARTITA + "\r\n");
    strAspettatas.append(Strings.CAMBIO_TURNO + Strings.GIOCATORE_BIANCO + "\r\n");
    strInseritas.append("mosse\n");
    strAspettatas.append(Strings.NESSUNA_MOSSA + "\r\n");
    strInseritas.append("pippo\n");
    strAspettatas.append(Strings.COMANDO_ERRATO + "\r\n");
    strInseritas.append("esci\n");
    strAspettatas.append(Strings.ERRORE_COMANDO_FUORI_GIOCO + "\r\n");
    strInseritas.append("help\n");
    strAspettatas.append(Strings.HELP_MSG + "\r\n");
    strInseritas.append("damiera\n");
    strAspettatas.append("\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m " +
        "\u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m " +
        "\u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m " +
        "\u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m " +
        "\u2003 \u001B[0m\n" + "\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m" +
        "\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m" +
        "\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m" +
        "\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m" +
        "\u26C2\u001B[39m \u001B[0m\n" + "\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m" +
        "\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m " +
        "\u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m " +
        "\u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m " +
        "\u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\n" + "\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m " +
        "\u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m " +
        "\u2003 \u001B[0m\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m " +
        "\u2003 \u001B[0m\n" + "\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m " +
        "\u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m " +
        "\u2003 \u001B[0m\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\n" + "\u001B[48;2;255;255;202m " +
        "\u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 " +
        "\u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 " +
        "\u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 " +
        "\u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\n" + "\u001B[48;2;102;117;189m " +
        "\u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m " +
        "\u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m " +
        "\u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m " +
        "\u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\n" + "\u001B[48;2;255;255;202m " +
        "\u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m " +
        "\u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m " +
        "\u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m " +
        "\u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\n" + "\r\n");
    strInseritas.append("numeri\n");
    strAspettatas.append(numeri);
    strInseritas.append("tempo\n");
    strAspettatas.append("Tempo giocatore bianco 00:00\n" + "Tempo giocatore nero 00:00"+ "\r\n");
    strInseritas.append("21-18\n");
    strAspettatas.append(Strings.AVVISO_SPOSTAMENTO + "\r\n");
    strAspettatas.append(Strings.CAMBIO_TURNO + Strings.GIOCATORE_NERO + "\r\n");
    strInseritas.append("11-14\n");
    strAspettatas.append(Strings.AVVISO_SPOSTAMENTO +"\r\n");
    strAspettatas.append(Strings.CAMBIO_TURNO + Strings.GIOCATORE_BIANCO+"\r\n");
    strInseritas.append("18x11\n");
    strAspettatas.append(Strings.AVVISO_PRESA +"\r\n");
    strAspettatas.append(Strings.CAMBIO_TURNO + Strings.GIOCATORE_NERO+"\r\n");
    strInseritas.append("7x14\n");
    strAspettatas.append(Strings.AVVISO_PRESA +"\r\n");
    strAspettatas.append(Strings.CAMBIO_TURNO + Strings.GIOCATORE_BIANCO+"\r\n");
    strInseritas.append("mosse\n");
    strAspettatas.append("B: 21-18\r\n");
    strAspettatas.append("N: 11-14\r\n");
    strAspettatas.append("B: 18x11\r\n");
    strAspettatas.append("N: 7x14"+"\r\n");
    strInseritas.append("prese\n");
    strAspettatas.append(Strings.PRESE_MSG + Strings.GIOCATORE_BIANCO + ": " + Strings.PEDINA_NERA + "\n"
        + Strings.PRESE_MSG + Strings.GIOCATORE_NERO + ": " + Strings.PEDINA_BIANCA + "\r\n");
    strInseritas.append("abbandona\n");
    strAspettatas.append(Strings.CONFERMA_ABBANDONO + "\r\n");
    strInseritas.append("pippo\n");
    strAspettatas.append(Strings.RISPOSTA_ERRATA + "\r\n");
    strInseritas.append("no\n");
    strAspettatas.append(Strings.PARTITA_NON_ABBANDONATA +"\r\n");
    strInseritas.append("abbandona\n");
    strAspettatas.append(Strings.CONFERMA_ABBANDONO + "\r\n");
    strInseritas.append("si\n");
    strAspettatas.append(Strings.PARTITA_ABBANDONATA + "\r\n");
    strAspettatas.append(Strings.FINE_PARTITA + Strings.GIOCATORE_NERO + "\r\n");
    strInseritas.append("esci\n");
    strAspettatas.append(Strings.CONFERMA_USCITA + "\r\n");
    strInseritas.append("pippo\n");
    strAspettatas.append(Strings.RISPOSTA_ERRATA + "\r\n");
    strInseritas.append("no\n");
    strAspettatas.append(Strings.USCITA_NON_ESEGUITA + "\r\n");
    strInseritas.append("esci\n");
    strAspettatas.append(Strings.CONFERMA_USCITA + "\r\n");
    strInseritas.append("si\n");
    try {
      System.setIn(new ByteArrayInputStream(strInseritas.toString().getBytes("UTF-8")));
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      PrintStream ps = new PrintStream(baos, false, "UTF-8");
      PrintStream old = System.out;
      System.setOut(ps);

      GameModel gameModel = new GameModel(8);
      new GameController(gameModel);

      System.out.flush();
      System.setOut(old);
      assertEquals(strAspettatas.toString(), baos.toString("UTF-8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}

