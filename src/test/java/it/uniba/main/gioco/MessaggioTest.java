package it.uniba.main.gioco;

import it.uniba.main.utilities.Strings;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessaggioTest
{
  @Test
  public void testSetMsg()
  {
    String str = Strings.CAMBIO_TURNO+Strings.GIOCATORE_BIANCO;
    Messaggio.cambio_giocatore.setMsg(Strings.GIOCATORE_BIANCO);
    assertEquals(str, Messaggio.cambio_giocatore.getMsg());
  }

  @Test
  public void testGetMsg()
  {
    String str = Strings.CAMBIO_TURNO;
    assertEquals(str, Messaggio.cambio_giocatore.getMsg());
  }

}
