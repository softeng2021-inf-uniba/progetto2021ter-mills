package it.uniba.main.gioco;

import it.uniba.main.utilities.Strings;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusTest
{
  @Test
  public void testSetMsg()
  {
    String str = Strings.FINE_PARTITA+Strings.GIOCATORE_BIANCO;
    Status.partita_terminata.setMsg(Strings.GIOCATORE_BIANCO);
    assertEquals(str, Status.partita_terminata.getMsg());
  }

  @Test
  public void testGetMsg()
  {
    String str = Strings.INIZIO_PARTITA;
    assertEquals(str, Status.partita_iniziata.getMsg());
  }

}
