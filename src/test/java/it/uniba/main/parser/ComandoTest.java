package it.uniba.main.parser;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class ComandoTest
{
  @Test
  public void testGetComando()
  {
    String help = "help";
    assertEquals(Comando.help, Comando.getComando(help));
  }

  @Test
  public void testArgComando()
  {
    Comando cmd = Comando.getComando("help");
    assertEquals("help", cmd.getInputStr());
  }
}
