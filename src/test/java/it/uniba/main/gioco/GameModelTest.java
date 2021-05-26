package it.uniba.main.gioco;

import it.uniba.main.utilities.Cronometro;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameModelTest {
  private GameModel gameModel;

  @Before
  public void init() {
    gameModel = new GameModel(8);
    gameModel.startGame();
    gameModel.abbandonaPartita();
    gameModel.startGame();
  }

  @Test
  public void testEseguiSpostamentoSemplice() {
    gameModel.eseguiSpostamentoSemplice(21, 18);
    gameModel.eseguiSpostamentoSemplice(11, 14);

    gameModel.eseguiSpostamentoSemplice(24, 15);
    gameModel.eseguiSpostamentoSemplice(24, 100);

    gameModel.eseguiSpostamentoSemplice(17, 13);
    gameModel.eseguiSpostamentoSemplice(12, 15);

    gameModel.eseguiSpostamentoSemplice(100, 20);

    List<String> storicoMosse = new ArrayList<>();
    storicoMosse.add("B: 21-18");
    storicoMosse.add("N: 11-14");
    assertEquals(storicoMosse, gameModel.getStoricoMosse());
  }

  @Test
  public void testEseguiPresa() {
    assertEquals(0, gameModel.getPunteggioBianco());
    assertEquals(0, gameModel.getPunteggioNero());

    gameModel.eseguiSpostamentoSemplice(21, 18);
    gameModel.eseguiSpostamentoSemplice(11, 14);

    gameModel.eseguiPresa(new String[]{"18", "11"});
    gameModel.eseguiPresa(new String[]{"7", "14"});
    gameModel.eseguiPresa(new String[]{"24", "20"});

    assertEquals(1, gameModel.getPunteggioBianco());
    assertEquals(1, gameModel.getPunteggioNero());
  }

  @Test
  public void testAbbandonaPartita() {
    gameModel.eseguiSpostamentoSemplice(21,18);
    gameModel.abbandonaPartita();
    assertFalse(gameModel.getIsPlaying());
  }

  @Test
  public void testGetDamiera() {
    String str = "\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\n" + "\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\n" + "\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;75;0;120m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\n" + "\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u2003 \u001B[0m\n" + "\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u2003 \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\n" + "\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\n" + "\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\n" + "\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\u001B[48;2;255;255;202m \u2003 \u001B[0m\u001B[48;2;102;117;189m \u001B[38;2;247;217;23m\u26C2\u001B[39m \u001B[0m\n";
    assertEquals(str, gameModel.getDamiera());
  }

  @Test
  public void testGetDimDamiera() {
    int dim = 8;
    assertEquals(dim, gameModel.getDimDamiera());
  }

  @Test
  public void testGetOnStatusChanged() {
    assertNotNull(gameModel.getOnStatusChanged());
  }

  @Test
  public void testGetOnMessagesCalled() {
    assertNotNull(gameModel.getOnMessagesCalled());
  }

  @Test
  public void testCronometri() {
    Cronometro cronometroBianco = gameModel.getCronometroBianco();
    Cronometro cronometroNero = gameModel.getCronometroNero();
    assertNotNull(cronometroBianco);
    assertNotNull(cronometroNero);
    assertNotEquals(cronometroBianco, cronometroNero);
  }
}