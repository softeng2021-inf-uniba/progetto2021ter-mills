package it.uniba.gioco;

import it.uniba.parser.Comando;
import it.uniba.utilities.Observer;
import it.uniba.utilities.Strings;
import it.uniba.utilities.Utilities;


/**
 * <<Boundary>>
 * Classe che gestisce l'interazione con l'utente e mostra i messaggi
 */
public class GameController {
    /**
     * Model con la logica del gioco.
     */
    private GameModel gameModel;

    /**
     * Observer in ascolto del soggetto che notifica i cambiamenti di stato dell'app.
     */
    private Observer<Status> observerStatus = status -> System.out.println(status.getMsg());;

    /**
     * Observer in ascolto del soggetto che notifica i messaggi utilizzati durante il gioco.
     */
    private Observer<Messaggio> observerMessages = msg -> System.out.println(msg.getMsg());;

    private boolean uscitaRichiesta = false;


    /**
     * Costruttore della classe.
     */
    public GameController(final GameModel model) {
        this.gameModel = model;

        gameModel.getOnStatusChanged().register(observerStatus);
        gameModel.getOnMessagesCalled().register(observerMessages);

        Comando cmd = null;

        while (!uscitaRichiesta) {
            String str = Utilities.getStringaDaTastiera();
            str = Utilities.pulisciStringa(str);

            cmd = Comando.getComando(str);

            controlloComando(cmd);
        }

    }

    /**
     * Inizia una nuova partita.
     */
    private void avviaNuovaPartita() {
        gameModel.startGame();
    }
    /**
     * Consente di abbandoare la partita chiedendo prima conferma all'utente.
     */
    private void gestioneAbbandona() {
        Boolean risultato = null;
        System.out.println(Strings.CONFERMA_ABBANDONO);
        while (risultato == null) {
            String conferma = Utilities.getStringaDaTastiera();
            conferma = Utilities.pulisciStringa(conferma);
            if (conferma.equalsIgnoreCase("si")) {
                System.out.println(Strings.PARTITA_ABBANDONATA);
                gameModel.abbandonaPartita();
                risultato = true;
            } else if (conferma.equalsIgnoreCase("no")) {
                System.out.println(Strings.PARTITA_NON_ABBANDONATA);
                risultato = false;
            } else {
                System.out.println(Strings.RISPOSTA_ERRATA);
            }
        }
    }

    /**
     * Esegue la stampa a schermo della damiera nello stato corrente.
     */
    private void stampaDamiera() {
        System.out.println(gameModel.getDamiera());
    }

    /**
     * Esegye la stampa a schermo della damiera, nella quale non vi sono le pedine ma i numeri che
     * identiifcano ciascuna casella.
     */
    private void stampaNumeri() {
        int dim = gameModel.getDimDamiera();
        StringBuffer stringa = new StringBuffer();
        int contatore = 1;
        int numCaselleNere = (int) Math.floor(Math.log10((dim * dim) / 2.0));
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (((i * (dim + 1) + j) % 2) == 0) {
                    stringa.append(Strings.RGB_INDACO_BG + Strings.ANSI_BLACK_FG + contatore);

                    for (int k = 0; k < numCaselleNere - Math.floor(Math.log10(contatore)); k++) {
                        stringa.append(Strings.RGB_INDACO_BG + Strings.RGB_INDACO_FG + "_");
                    }
                    stringa.append(" ");
                    contatore++;
                } else {
                    stringa.append(Strings.RGB_CREMA_BG);
                    for (int k = 0; k <= numCaselleNere; k++) {
                        stringa.append(Strings.RGB_CREMA_BG + Strings.RGB_CREMA_FG + "_");
                    }
                    stringa.append(" ");
                }
            }
            stringa.append(Strings.ANSI_RESET + "\n");
        }
        System.out.println(stringa.toString());
    }

    /**
     * Esegue la presa.
     */
     private void presa(final String arg) {
        String[] caselle = arg.split("x");
        gameModel.eseguiPresa(caselle);
    }


    /**
     * Esegue lo spostamento semplice.
     */
    private void spostamentoSemplice(final String arg) {
        String[] caselle = arg.split("-");
        gameModel.eseguiSpostamentoSemplice(Integer.parseInt(caselle[0]), Integer.parseInt(caselle[1]));
    }

    /**
     * Chiama il metodo relativo al comando passato come parametro con l'eventuale argomento.
     * I comandi consentiti sono solamente quelli possibili duramente il game.
     */
    private void comandiInGioco(final Comando cmd) {
        if (cmd == Comando.help) {
            System.out.println(Strings.HELP_MSG);
        } else if (cmd == Comando.abbandona) {
            gestioneAbbandona();
        } else if (cmd == Comando.damiera) {
            stampaDamiera();
        } else if (cmd == Comando.numeri) {
            stampaNumeri();
        } else if (cmd == Comando.tempo) {
            stampaTempoGiocatori();
        } else if (cmd == Comando.spostamentoSemplice) {
            spostamentoSemplice(cmd.getInputStr());
        } else if (cmd == Comando.presa) {
            presa(cmd.getInputStr());
        } else if (cmd == Comando.prese) {
            stampaPrese();
        } else if (cmd == Comando.mosse) {
            stampaStoricoMosse();
        } else {
            System.out.println(Strings.ERRORE_COMANDO_FUORI_GIOCO);
        }
    }


    /**
     * Chiama il metodo relativo al comando passato come parametro con l'eventuale argomento.
     * I comandi consentiti sono solamente quelli possibili furoi dal game.
     */
    private void comandiFuoriGioco(final Comando cmd) {
        if (cmd == Comando.help) {
            System.out.println(Strings.HELP_MSG);
        } else if (cmd == Comando.gioca) {
            avviaNuovaPartita();
        } else if (cmd == Comando.numeri) {
            stampaNumeri();
        } else if (cmd == Comando.esci) {
            esciDalGioco();
        } else {
            System.out.println(Strings.ERRORE_COMANDO_IN_GIOCO);
        }
    }


    /**
     * Stampa a schermo il tempo di entrambi i giocatori.
     */
    private void stampaTempoGiocatori() {
        long tempoBianco = gameModel.getCronometroBianco().getTempoTrascorsoMillis();
        long tempoNero = gameModel.getCronometroNero().getTempoTrascorsoMillis();
        String tempo = "Tempo " + Strings.GIOCATORE_BIANCO + " " + Utilities.getStringaTempo(tempoBianco);
        tempo += "\nTempo " + Strings.GIOCATORE_NERO + " " + Utilities.getStringaTempo(tempoNero);
        System.out.println(tempo);
    }


    /**
     * Consente di uscire dal gioco chiedendo prima conferma all'utente.
     */
    private void esciDalGioco() {
        Boolean risultato = null;

        System.out.println(Strings.CONFERMA_USCITA);
        while (risultato == null) {
            String conferma = Utilities.getStringaDaTastiera();
            conferma = Utilities.pulisciStringa(conferma);
            if (conferma.equalsIgnoreCase("si")) {
                risultato = true;
            } else if (conferma.equalsIgnoreCase("no")) {
                System.out.println(Strings.USCITA_NON_ESEGUITA);
                risultato = false;
            } else {
                System.out.println(Strings.RISPOSTA_ERRATA);
            }
        }
        uscitaRichiesta = risultato;
    }


    /**
     * Riceve in input un comando e a seconda dello stato del gioco lo esegue o meno.
     * Se il comando non e' valido verra' mostrato a schermo un messaggio di errore.
     */
    private void controlloComando(final Comando cmd) {
        if (cmd == null) {
            System.out.println(Strings.COMANDO_ERRATO);
        } else if (gameModel.getIsPlaying()) {
            comandiInGioco(cmd);
        } else {
            comandiFuoriGioco(cmd);
        }

    }

    /**
     * Esegue la stampa a schermo dello storico delle prese effettuate.
     */
     public void stampaPrese() {
        StringBuffer result = new StringBuffer();
        result.append(Strings.PRESE_MSG + Strings.GIOCATORE_BIANCO + ": ");
        for (int i = 0; i < gameModel.getPunteggioBianco(); i++) {
            result.append(Strings.PEDINA_NERA);
        }
        result.append("\n" + Strings.PRESE_MSG + Strings.GIOCATORE_NERO + ": ");
        for (int i = 0; i < gameModel.getPunteggioNero(); i++) {
            result.append(Strings.PEDINA_BIANCA);
        }
        System.out.println(result.toString());
    }

    /**
     * Esegue la stampa a schermo dello storico delle mosse effettuate.
     */
    public void stampaStoricoMosse() {
        if (gameModel.getStoricoMosse().size() <= 0) {
            System.out.println(Strings.NESSUNA_MOSSA);
        } else {
            for (int i = 0; i < gameModel.getStoricoMosse().size(); i++) {
                System.out.println(gameModel.getStoricoMosse().get(i));
            }
        }
    }
}
