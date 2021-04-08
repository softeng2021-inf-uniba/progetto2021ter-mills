package it.uniba.main.utilities;

public class Strings
{
    public static final char PEDINA_BIANCA = 0x26C0;
    public static final char PEDINA_REGINA_BIANCA = 0x26C1;
    public static final char PEDINA_NERA = 0x26C2;
    public static final char PEDINA_REGINA_NERA = 0x26C3;

    public static final String BENVENUTO =
            PEDINA_REGINA_BIANCA + " Benvenuto nella Dama Italiana " + PEDINA_REGINA_NERA + "\n";

    public static final String HELP = "help\t\tmostra la lista dei comandi disponibili\n";
    public static final String SUGGERIMENTO_HELP = "Digitare un comando o scrivere 'help' per visualizzare la lista " +
            "dei comandi disponibili\n";
    public static final String GIOCA = "gioca\t\tpermette di iniziare una nuova partita\n";
    public static final String ABBANDONA = "abbandona\tabbandona la partita (sconfitta a tavolino)\n";
    public static final String ESCI = "esci\t\tchiude il programma previa conferma\n";
    public static final String NUMERI = "numeri\t\tmostra la damiera numerata\n";
    public static final String DAMIERA = "damiera\t\tmostra la damiera con le pedine\n";
    public static final String TEMPO = "tempo\t\tmostra il tempo trascorso per entrambi i giocatori\n";
    public static final String HELP_MSG = "Comandi disponibili:\n" + HELP + GIOCA + ABBANDONA + ESCI + NUMERI + DAMIERA + TEMPO;

}
