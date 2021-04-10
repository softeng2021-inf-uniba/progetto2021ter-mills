package it.uniba.main.gioco;

import it.uniba.main.parser.Comando;
import it.uniba.main.utilities.Strings;
import it.uniba.main.utilities.Utilities;

public class GameController
{
    GameModel gameModel;
    ObserverStatus observerStatus = status -> stampaNuvoStato(status);

    public GameController(GameModel gameModel)
    {
        this.gameModel = gameModel;

        gameModel.getOnStatusChanged().register(observerStatus);

        Comando cmd = null;

        while (true)
        {
            String str = Utilities.getStringaDaTastiera();
            str = Utilities.pulisciStringa(str);

            cmd = Comando.getComando(str);

            controlloComando(cmd);
        }
    }


    private void avviaNuovaPartita()
    {
        gameModel.startGame();
        //TODO
    }

    private void comandiInGioco(Comando cmd)
    {
        if (cmd == Comando.help)
        {
            System.out.println(Strings.HELP_MSG);
        }

        else
        {
            System.out.println(Strings.ERRORE_COMANDO_GENERICO);
        }
    }

    private void comandiFuoriGioco(Comando cmd)
    {
        if (cmd == Comando.help)
        {
            System.out.println(Strings.HELP_MSG);
        }
        else if (cmd == Comando.gioca)
        {
            avviaNuovaPartita();
        }
        else
        {
            System.out.println(Strings.ERRORE_COMANDO_GENERICO);
        }
    }

    private void stampaNuvoStato(Status status)
    {
        System.out.println(status.getMsg());
    }

    private void controlloComando(Comando cmd)
    {
        if (gameModel.getIsPlaying())
        {
            comandiInGioco(cmd);
        }
        else
        {
            comandiFuoriGioco(cmd);
        }

    }
}
