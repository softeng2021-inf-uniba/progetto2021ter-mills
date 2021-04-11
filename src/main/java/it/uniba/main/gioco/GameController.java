package it.uniba.main.gioco;

import it.uniba.main.gioco.damiera.*;
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

    private void gestioneAbbandona()
    {
        Boolean risultato = null;
        System.out.println(Strings.CONFERMA_ABBANDONO);
        while (risultato == null)
        {
            String conferma = Utilities.getStringaDaTastiera();
            Utilities.pulisciStringa(conferma);
            if (conferma.equalsIgnoreCase("si"))
            {
                System.out.println(Strings.PARTITA_ABBANDONATA);
                gameModel.abbandonaPartita();
                risultato = true;
            }
            else if (conferma.equalsIgnoreCase("no"))
            {
                System.out.println(Strings.PARTITA_NON_ABBANDONATA);
                risultato = false;
            }
            else
            {
                System.out.println(Strings.COMANDO_ERRATO);
            }
        }
    }

    private void stampaDamiera()
    {
        Casella[][] dama = gameModel.getDamiera();
        String stringa = "";

        for (int riga = dama.length - 1; riga >= 0; riga--)
        {
            for (int colonna = 0; colonna < dama.length; colonna++)
            {
                stringa += dama[riga][colonna].toString();
            }
            stringa += "\n";
        }
        stringa += " " + (char) 0x2002;

        System.out.println(stringa);
    }

    private void stampaNumeri()
    {
        int DIM = gameModel.getDimDamiera();
        String stringa = "";
        int contatore = 1;
        int numCaselleNere = (int)Math.floor(Math.log10((DIM * DIM) / 2));
        for (int i = 0; i < DIM; i++)
        {
            for (int j = 0; j < DIM; j++)
            {
                if (((i * (DIM + 1) + j) % 2) == 0)
                {
                    stringa += Strings.RGB_INDACO + Strings.ANSI_BLACK_FG + contatore;
                    for (int k = 0; k < numCaselleNere - Math.floor(Math.log10(contatore)); k++)
                    {
                        stringa += " ";
                    }
                    contatore++;
                }
                else
                {
                    stringa += Strings.RGB_CREMA;
                    for (int k = 0; k <= numCaselleNere; k++)
                    {
                        stringa += " ";
                    }
                }
            }
            stringa += Strings.ANSI_RESET + "\n";
        }
        System.out.println(stringa);
    }

    private void comandiInGioco(Comando cmd)
    {
        if (cmd == Comando.help)
        {
            System.out.println(Strings.HELP_MSG);
        }
        else if (cmd == Comando.abbandona)
        {
            gestioneAbbandona();
        }
        else if (cmd == Comando.damiera)
        {
            stampaDamiera();
        }
        else if (cmd == Comando.numeri)
        {
            stampaNumeri();
        }
        else
        {
            System.out.println(Strings.ERRORE_COMANDO_FUORI_GIOCO);
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
        else if (cmd == Comando.numeri)
        {
            stampaNumeri();
        }
        else
        {
            System.out.println(Strings.ERRORE_COMANDO_IN_GIOCO);
        }
    }

    private void stampaNuvoStato(Status status)
    {
        System.out.println(status.getMsg());
    }

    private void controlloComando(Comando cmd)
    {
        if (cmd == null)
        {
            System.out.println(Strings.COMANDO_ERRATO);
        }
        else if (gameModel.getIsPlaying())
        {
            comandiInGioco(cmd);
        }
        else
        {
            comandiFuoriGioco(cmd);
        }

    }
}
