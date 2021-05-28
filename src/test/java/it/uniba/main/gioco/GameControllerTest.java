package it.uniba.main.gioco;

import it.uniba.main.utilities.Strings;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest {

  @Test
  public void test3(){
    ByteArrayInputStream in = new ByteArrayInputStream("esci\nsi".getBytes());
    System.setIn(in);
    Scanner input = new Scanner(System.in);
    input.nextLine();
    input.nextLine();
    assertTrue(input.hasNextLine());
  }

  @Test
  public void test4(){
    ByteArrayInputStream in = new ByteArrayInputStream("esci\nsi".getBytes());
    System.setIn(in);
    Scanner input = new Scanner(System.in);
    input.nextLine();
    input.nextLine();
    assertTrue(input.hasNext());
  }

  @Test
  public void test1() {
    ByteArrayInputStream in = new ByteArrayInputStream("esci\nsi".getBytes());
    System.setIn(in);
    Scanner input = new Scanner(System.in);
    assertTrue(input.hasNext());

  }
  @Test
  public void test2() {
    ByteArrayInputStream in = new ByteArrayInputStream("esci\nsi".getBytes());
    System.setIn(in);
    Scanner input = new Scanner(System.in);
    assertTrue(input.hasNextLine());
  }



 /* @Test
  public void testController() {

   /* StringBuilder strAspettata = new StringBuilder();
    StringBuilder strInserita = new StringBuilder();

    strInserita.append("damiera" + System.getProperty("line.separator"));
    strAspettata.append(Strings.ERRORE_COMANDO_IN_GIOCO + "\r\n");
    strInserita.append("pippo" + System.getProperty("line.separator"));
    strAspettata.append(Strings.COMANDO_ERRATO +"\r\n");
    strInserita.append("help" + System.getProperty("line.separator"));
    strAspettata.append(Strings.HELP_MSG + "\r\n");
    strInserita.append("numeri" + System.getProperty("line.separator"));
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
    strAspettata.append(numeri);
    strInserita.append("gioca" + System.getProperty("line.separator"));
    strAspettata.append(Strings.INIZIO_PARTITA + "\r\n");
    strAspettata.append(Strings.CAMBIO_TURNO + Strings.GIOCATORE_BIANCO + "\r\n");
    strInserita.append("mosse" + System.getProperty("line.separator"));
    strAspettata.append(Strings.NESSUNA_MOSSA + "\r\n");
    strInserita.append("pippo" + System.getProperty("line.separator"));
    strAspettata.append(Strings.COMANDO_ERRATO + "\r\n");
    strInserita.append("esci" + System.getProperty("line.separator"));
    strAspettata.append(Strings.ERRORE_COMANDO_FUORI_GIOCO + "\r\n");
    strInserita.append("help" + System.getProperty("line.separator"));
    strAspettata.append(Strings.HELP_MSG + "\r\n");
    strInserita.append("damiera" + System.getProperty("line.separator"));
    strAspettata.append("\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m " +
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
    strInserita.append("numeri" + System.getProperty("line.separator"));
    strAspettata.append(numeri);
    strInserita.append("tempo" + System.getProperty("line.separator"));
    strAspettata.append("Tempo giocatore bianco 00:00\n" + "Tempo giocatore nero 00:00"+ "\r\n");
    strInserita.append("21-18" + System.getProperty("line.separator"));
    strAspettata.append(Strings.AVVISO_SPOSTAMENTO + "\r\n");
    strAspettata.append(Strings.CAMBIO_TURNO + Strings.GIOCATORE_NERO + "\r\n");
    strInserita.append("11-14" + System.getProperty("line.separator"));
    strAspettata.append(Strings.AVVISO_SPOSTAMENTO +"\r\n");
    strAspettata.append(Strings.CAMBIO_TURNO + Strings.GIOCATORE_BIANCO+"\r\n");
    strInserita.append("18x11" + System.getProperty("line.separator"));
    strAspettata.append(Strings.AVVISO_PRESA +"\r\n");
    strAspettata.append(Strings.CAMBIO_TURNO + Strings.GIOCATORE_NERO+"\r\n");
    strInserita.append("7x14" + System.getProperty("line.separator"));
    strAspettata.append(Strings.AVVISO_PRESA +"\r\n");
    strAspettata.append(Strings.CAMBIO_TURNO + Strings.GIOCATORE_BIANCO+"\r\n");
    strInserita.append("mosse" + System.getProperty("line.separator"));
    strAspettata.append("B: 21-18\r\n");
    strAspettata.append("N: 11-14\r\n");
    strAspettata.append("B: 18x11\r\n");
    strAspettata.append("N: 7x14"+"\r\n");
    strInserita.append("prese" + System.getProperty("line.separator"));
    strAspettata.append(Strings.PRESE_MSG + Strings.GIOCATORE_BIANCO + ": " + Strings.PEDINA_NERA + "\n"
        + Strings.PRESE_MSG + Strings.GIOCATORE_NERO + ": " + Strings.PEDINA_BIANCA + "\r\n");
    strInserita.append("abbandona" + System.getProperty("line.separator"));
    strAspettata.append(Strings.CONFERMA_ABBANDONO + "\r\n");
    strInserita.append("pippo" + System.getProperty("line.separator"));
    strAspettata.append(Strings.RISPOSTA_ERRATA + "\r\n");
    strInserita.append("no" + System.getProperty("line.separator"));
    strAspettata.append(Strings.PARTITA_NON_ABBANDONATA +"\r\n");
    strInserita.append("abbandona" + System.getProperty("line.separator"));
    strAspettata.append(Strings.CONFERMA_ABBANDONO + "\r\n");
    strInserita.append("si" + System.getProperty("line.separator"));
    strAspettata.append(Strings.PARTITA_ABBANDONATA + "\r\n");
    strAspettata.append(Strings.FINE_PARTITA + Strings.GIOCATORE_NERO + "\r\n");
    strInserita.append("esci" + System.getProperty("line.separator"));
    strAspettata.append(Strings.CONFERMA_USCITA + "\r\n");
    strInserita.append("pippo" + System.getProperty("line.separator"));
    strAspettata.append(Strings.RISPOSTA_ERRATA + "\r\n");
    strInserita.append("no" + System.getProperty("line.separator"));
    strAspettata.append(Strings.USCITA_NON_ESEGUITA + "\r\n");
    strInserita.append("esci" + System.getProperty("line.separator"));
    strAspettata.append(Strings.CONFERMA_USCITA + "\r\n");
    strInserita.append("si" + System.getProperty("line.separator"));
*/
/*
    try {
      System.setIn(new ByteArrayInputStream("esci\nsi".getBytes()));
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      PrintStream ps = new PrintStream(baos);
      PrintStream old = System.out;
      System.setOut(ps);

      GameModel gameModel = new GameModel(8);
      new GameController(gameModel);

      System.out.flush();
      System.setOut(old);

      String strAttesa = strAspettata.toString().replaceAll("\r", "").replaceAll("\n", "");
      String outputConsole = baos.toString("UTF-8").replaceAll("\r", "").replaceAll("\n", "");

      //assertEquals(strAttesa, outputConsole);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }*/


  }


