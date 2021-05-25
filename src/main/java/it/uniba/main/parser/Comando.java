package it.uniba.main.parser;

/**
 * <<noECB>>
 * Enumerativo che contiene tutti i comandi disponibili. Esso funge anche da parser dei comandi.
 */
public enum Comando {
    /**
     * Comandi ammessi, con eventuali alias.
     */
    help(new String[]{"-h", "--help", "help"}),
    gioca(new String[]{"gioca", "play"}),
    abbandona(new String[]{"abbandona", "quit"}),
    damiera(new String[]{"damiera"}),
    numeri(new String[]{"numeri"}),
    esci(new String[]{"esci", "exit"}),
    tempo(new String[]{"tempo", "time"}),
    spostamentoSemplice(new String[]{"(\\d+)-(\\d+)"}),
    presa(new String[]{"((\\d+)x)+(\\d+)"}),
    prese(new String[]{"prese"}),
    mosse(new String[]{"mosse"});
    /**
     * Stringa presa in input.
     */
    private String inputStr;

    /**
     * Array di alias per gli enumerativi.
     */
    private String[] aliasList;

    /**
     * Costruttore dell'enumerativo Comando.
     *
     * @param aliasListPassed nome alternativo di un enumerativo
     */
    Comando(final String[] aliasListPassed) {
        this.aliasList = aliasListPassed;
    }

    /**
     * Metodo utilizzato per vedere se il comando scritto esiste, per associare
     * un eventuale alias ad un comando esistente.
     *
     * @param str stringa passata in input
     * @return ritorna il comando associato alla stringa passata se quest'ultima esiste
     */
    public static Comando getComando(final String str) {
        Comando comandoTrovato = null;

        Comando[] listaComandi = Comando.values();

        for (int i = 0; i < listaComandi.length && comandoTrovato == null; ++i) {
            Comando cmd = listaComandi[i];
            for (int j = 0; j < cmd.aliasList.length && comandoTrovato == null; ++j) {
                if (str.toLowerCase().matches("^" + cmd.aliasList[j] + "$")) {
                    comandoTrovato = cmd;
                }
            }
        }

        if (comandoTrovato != null) {
            comandoTrovato.inputStr = str;
        }

        return comandoTrovato;
    }

    /**
     * Metodo getter della stringa passata in input.
     *
     * @return la stringa passata in input
     */
    public String getInputStr() {
        return inputStr;
    }
}
