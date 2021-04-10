package it.uniba.main.utilities;

public class Strings
{
    public static final char PEDINA_BIANCA = 0x26C0;
    public static final char PEDINA_REGINA_BIANCA = 0x26C1;
    public static final char PEDINA_NERA = 0x26C2;
    public static final char PEDINA_REGINA_NERA = 0x26C3;

    public static final String BENVENUTO =
            PEDINA_REGINA_BIANCA + " Benvenuto nella Dama Italiana " + PEDINA_REGINA_NERA + "\n";

    // stringhe per msg help
    private static final String HELP = "help\t\tmostra la lista dei comandi disponibili\n";
    private static final String GIOCA = "gioca\t\tpermette di iniziare una nuova partita\n";
    private static final String ABBANDONA = "abbandona\tabbandona la partita (sconfitta a tavolino)\n";
    private static final String ESCI = "esci\t\tchiude il programma previa conferma\n";
    private static final String NUMERI = "numeri\t\tmostra la damiera numerata\n";
    private static final String DAMIERA = "damiera\t\tmostra la damiera con le pedine\n";
    private static final String TEMPO = "tempo\t\tmostra il tempo trascorso per entrambi i giocatori\n";


    public static final String HELP_MSG = "Comandi disponibili:\n" + HELP + GIOCA + ABBANDONA + ESCI + NUMERI + DAMIERA + TEMPO;
    public static final String SUGGERIMENTO_HELP = "Digitare un comando o scrivere 'help' per visualizzare la lista " +
            "dei comandi disponibili\n";

    public static final String ERRORE_COMANDO_GENERICO = "Non puoi esegurie questo comando adesso\n";
    public static final String COMANDO_ERRATO = "Comando errato";


    // stringhe in gioco
    public static final String GIOCATORE_BIANCO = "giocatore bianco";
    public static final String GIOCATORE_NERO = "giocatore nero";
    public static final String INIZIO_PARTITA = "Partita iniziata ...";
    public static final String FINE_PARTITA = "Partita finita. Vince: ";

    //stringhe per abbandono
    public static final String CONFERMA_ABBANDONO = "Vuoi veramente abbandonare? [si/no]";
    public static final String PARTITA_ABBANDONATA = "Hai abbandonato la partita";
    public static final String PARTITA_NON_ABBANDONATA = "La partita continua...";

}
