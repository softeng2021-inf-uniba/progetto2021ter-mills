package it.uniba.main.utilities;

public class Strings
{
    //colori
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RESET_FG = "\u001B[39m";
    public static final String ANSI_RESET_BG = "\u001B[49m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_ITALIC = "\u001B[3m";

    public static final String ANSI_GREEN_BG = "\u001B[42m";
    public static final String ANSI_BRIGHT_WHITE_BG = "\u001B[107m";
    public static final String ANSI_RED_BG = "\u001B[41m";


    public static final String ANSI_BLACK_FG = "\u001B[30m";

    public static final String RGB_CREMA_BG = "\u001B[48;2;255;255;202m";
    public static final String RGB_INDACO_BG = "\u001B[48;2;102;117;189m";
    public static final String RGB_CREMA_FG = "\u001B[38;2;255;255;202m";
    public static final String RGB_INDACO_FG = "\u001B[38;2;102;117;189m";
    public static final String RGB_GIALLO_FG = "\u001B[38;2;247;217;23m";
    public static final String RGB_VIOLA_FG = "\u001B[38;2;75;0;120m";
    public static final String RGB_NERO_FG = "\u001B[38;2;0;0;0m";




    public static final String PEDINA_BIANCA = RGB_GIALLO_FG + (char) 0x26C2 + ANSI_RESET_FG;
//    public static final String PEDINA_REGINA_BIANCA = RGB_GIALLO_FG + (char) 0x26C3 + ANSI_RESET_FG;
    public static final String PEDINA_NERA = RGB_VIOLA_FG + (char) 0x26C2 + ANSI_RESET_FG;
//    public static final String PEDINA_REGINA_NERA = RGB_VIOLA_FG + (char) 0x26C3 + ANSI_RESET_FG;
    public static final char CASELLA_VUOTA = 0x2003;

    public static final String BENVENUTO = ANSI_RESET +
            RGB_NERO_FG + ANSI_GREEN_BG + "" + (char) 0x26C3 +
            ANSI_BOLD + ANSI_ITALIC +
            ANSI_GREEN_BG + " Benvenuto " +
            ANSI_BRIGHT_WHITE_BG + " nella Dama " +
            ANSI_RED_BG + " Italiana " +
            ANSI_RESET + RGB_NERO_FG + ANSI_RED_BG + (char) 0x26C3 +
            ANSI_RESET + " ";


    public static final String ERRORE_GENERICO = "Errore: ";

    // stringhe per msg help
    private static final String HELP = "help\t\tmostra la lista dei comandi disponibili\n";
    private static final String GIOCA = "gioca\t\tpermette di iniziare una nuova partita\n";
    private static final String ABBANDONA = "abbandona\tabbandona la partita (sconfitta a tavolino)\n";
    private static final String ESCI = "esci\t\tchiude il programma previa conferma\n";
    private static final String NUMERI = "numeri\t\tmostra la damiera numerata\n";
    private static final String DAMIERA = "damiera\t\tmostra la damiera con le pedine\n";
    private static final String TEMPO = "tempo\t\tmostra il tempo trascorso per entrambi i giocatori\n";
    private static final String PRESE = "prese\t\tmostra le prese di entrambi i giocatori\n";
    private static final String MOSSE = "mosse\t\tmostra lo storico delle mosse\n";
    private static final String SPOSTAMENTI = "\nLe mosse sono descritte in notazione algebrica:\n" +
            "Spostamento:\t1-5\n" +
            "Presa semplice:\t1x10\n" +
            "Presa multipla:\t1x10x...x32\n";


    public static final String HELP_MSG =
            "Comandi disponibili:\n" + HELP + GIOCA + ABBANDONA + ESCI + NUMERI + DAMIERA + TEMPO + PRESE + MOSSE + SPOSTAMENTI;
    public static final String SUGGERIMENTO_HELP = "Digitare un comando o scrivere 'help' per visualizzare la lista " + "dei comandi disponibili\n";

    public static final String ERRORE_COMANDO_GENERICO = "Non puoi esegurie questo comando adesso\n";
    public static final String COMANDO_ERRATO = "Comando errato";
    public static final String ERRORE_COMANDO_FUORI_GIOCO = "Questo comando può essere utilizzato solamente fuori dalla partita";
    public static final String ERRORE_COMANDO_IN_GIOCO = "Questo comando può essere utilizzato solamente durante la partita\nInserire comando 'gioca' per iniziare una nuova partita";

    // stringhe in gioco
    public static final String GIOCATORE_BIANCO = "giocatore bianco";
    public static final String GIOCATORE_NERO = "giocatore nero";
    public static final String INIZIO_PARTITA = "Partita iniziata ...";
    public static final String FINE_PARTITA = "Partita finita. Vince: ";
    public static final String MOSSA_ESEGUITA = "Mossa eseguita";
    public static final String CAMBIO_TURNO = "È il turno del ";
    public static final String POSIZIONE_OUT_OF_RANGE = "Hai inserito una posizione al di fuori della damiera";
    public static final String SPOSTAMENTO_ERRATO = "Non puoi fare questo spostamento";
    public static final String MSG_CASELLA_VUOTA = "Hai selezionato una casella vuota";
    public static final String PEDINA_AVVERSARIA = "Hai selezionato una pedina avversaria";
    public static final String PRESE_MSG = "Prese del ";
    public static final String NESSUNA_MOSSA = "Nessuna mossa effettuata";

    //stringhe per abbandono
    public static final String CONFERMA_ABBANDONO = "Vuoi veramente abbandonare? [si/no]";
    public static final String PARTITA_ABBANDONATA = "Hai abbandonato la partita";
    public static final String PARTITA_NON_ABBANDONATA = "La partita continua...";
    public static final String RISPOSTA_ERRATA = "Risposta non permessa! Riprova con 'si' o 'no'";

    //stringhe per uscita
    public static final String CONFERMA_USCITA = "Vuoi veramente chiudere il gioco? [si/no]";
    public static final String USCITA_NON_ESEGUITA = "Uscita non eseguita...";

}
