package it.uniba.main.gioco;

import it.uniba.main.parser.Comando;
import it.uniba.main.utilities.Strings;
import it.uniba.main.utilities.Utilities;

public class GameController
{
    public GameController()
    {
        Comando cmd = null;
        while(true)
        {
            String str = Utilities.getStringaDaTastiera();
            str = Utilities.pulisciStringa(str);

            cmd = Comando.getComando(str);

            controlloComando(cmd);
        }
    }

    private void controlloComando(Comando cmd)
    {
        if (cmd == Comando.Help)
        {
            System.out.println(Strings.HELP_MSG);
        }
    }
}
