package it.uniba.main.gioco;

import it.uniba.main.gioco.damiera.*;
import it.uniba.main.parser.Comando;
import it.uniba.main.utilities.Observer;
import it.uniba.main.utilities.Posizione;
import it.uniba.main.utilities.Strings;
import it.uniba.main.utilities.Utilities;


/**
 * <<Boundary>>
 * Classe che gestisce l'interazione con l'utente e mostra i messaggi
 */
public class GameController
{
    private GameModel gameModel;

    private Observer<Status> observerStatus = status -> stampaNuovoStato(status);
    private Observer<Messaggio> observerMessages = msg -> stampaNuovoMessaggio(msg);

    private boolean uscitaRichiesta = false;

    public GameController(GameModel gameModel)
    {
        this.gameModel = gameModel;

        gameModel.getOnStatusChanged().register(observerStatus);
        gameModel.getOnMessagesCalled().register(observerMessages);

        Comando cmd = null;

        while (!uscitaRichiesta)
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
                System.out.println(Strings.RISPOSTA_ERRATA);
            }
        }
    }

    private void stampaDamiera()
    {
        System.out.println(gameModel.getDamiera());
    }

    private void stampaNumeri()
    {
        int DIM = gameModel.getDimDamiera();
        String stringa = "";
        int contatore = 1;
        int numCaselleNere = (int) Math.floor(Math.log10((DIM * DIM) / 2));
        for (int i = 0; i < DIM; i++)
        {
            for (int j = 0; j < DIM; j++)
            {
                if (((i * (DIM + 1) + j) % 2) == 0)
                {
                    stringa += Strings.RGB_INDACO_BG + Strings.ANSI_BLACK_FG + contatore;

                    for (int k = 0; k < numCaselleNere - Math.floor(Math.log10(contatore)); k++)
                    {
                        stringa += Strings.RGB_INDACO_BG + Strings.RGB_INDACO_FG + "_";
                    }
                    stringa += " ";
                    contatore++;
                }
                else
                {
                    stringa += Strings.RGB_CREMA_BG;
                    for (int k = 0; k <= numCaselleNere; k++)
                    {
                        stringa += Strings.RGB_CREMA_BG + Strings.RGB_CREMA_FG + "_";
                    }
                    stringa += " ";
                }
            }
            stringa += Strings.ANSI_RESET + "\n";
        }
        System.out.println(stringa);
    }


    void presa(String arg)
    {
        String caselle[] = arg.split("x");
        gameModel.eseguiPresa(caselle);
    }

    void spostamentoSemplice(String arg)
    {
        String caselle[] = arg.split("-");
        gameModel.eseguiSpostamentoSemplice(Integer.parseInt(caselle[0]), Integer.parseInt(caselle[1]));
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
        else if (cmd == Comando.tempo)
        {
            stampaTempoGiocatori();
        }
        else if (cmd == Comando.spostamentoSemplice)
        {
            spostamentoSemplice(cmd.getArgComando());
        }
        else if (cmd == Comando.presa)
        {
            presa(cmd.getArgComando());
        }
        else if (cmd == Comando.prese)
        {
            stampaPrese();
        }
        else if (cmd == Comando.mosse)
        {
            stampaStoricoMosse();
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
        else if (cmd == Comando.esci)
        {
            esciDalGioco();
        }
        else
        {
            System.out.println(Strings.ERRORE_COMANDO_IN_GIOCO);
        }
    }

    private void stampaTempoGiocatori()
    {
        long tempoBianco = gameModel.getCronometroBianco().getTempoTrascorsoMillis();
        long tempoNero = gameModel.getCronometroNero().getTempoTrascorsoMillis();
        String tempo = "Tempo " + Strings.GIOCATORE_BIANCO + " " + Utilities.getStringaTempo(tempoBianco);
        tempo += "\nTempo " + Strings.GIOCATORE_NERO + " " + Utilities.getStringaTempo(tempoNero);
        System.out.println(tempo);
    }

    private void esciDalGioco()
    {
        Boolean risultato = null;

        System.out.println(Strings.CONFERMA_USCITA);
        while (risultato == null)
        {
            String conferma = Utilities.getStringaDaTastiera();
            Utilities.pulisciStringa(conferma);
            if (conferma.equalsIgnoreCase("si"))
            {
                risultato = true;
            }
            else if (conferma.equalsIgnoreCase("no"))
            {
                System.out.println(Strings.USCITA_NON_ESEGUITA);
                risultato = false;
            }
            else
            {
                System.out.println(Strings.RISPOSTA_ERRATA);
            }
        }
        uscitaRichiesta = risultato;
    }

    private void stampaNuovoStato(Status status)
    {
        System.out.println(status.getMsg());
    }

    private void stampaNuovoMessaggio(Messaggio msg)
    {
        System.out.println(msg.getMsg());
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

    public void stampaPrese()
    {
        String result = Strings.PRESE_MSG + Strings.GIOCATORE_BIANCO + ": ";
        for (int i = 0; i < gameModel.getPunteggioBianco(); i++)
        {
            result += Strings.PEDINA_NERA;
        }
        result += "\n" + Strings.PRESE_MSG + Strings.GIOCATORE_NERO + ": ";
        for (int i = 0; i < gameModel.getPunteggioNero(); i++)
        {
            result += Strings.PEDINA_BIANCA;
        }
        System.out.println(result);
    }

    public void stampaStoricoMosse()
    {
        if (gameModel.getStoricoMosse().size() <= 0)
        {
            System.out.println(Strings.NESSUNA_MOSSA);
        }
        else
        {
            for (int i = 0; i < gameModel.getStoricoMosse().size(); i++)
            {
                System.out.println(gameModel.getStoricoMosse().get(i));
            }
        }
    }
}
