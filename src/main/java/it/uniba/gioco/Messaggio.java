package it.uniba.gioco;

import it.uniba.utilities.Strings;

/** <<noECB>>
 * Enumerativo che contiene messaggi costituiti da una
 * prima parte fissa ed un'eventuale seconda parte variabile.
 */

public enum Messaggio {
    /**
     * Messaggi utilizzati durante il gioco.
     */
    errore_generico(Strings.ERRORE_GENERICO),
    presa_eseguita(Strings.AVVISO_PRESA),
    damatura_effettuata(Strings.AVVISO_DAMATURA),
    spostamento_effettuato(Strings.AVVISO_SPOSTAMENTO),
    cambio_giocatore(Strings.CAMBIO_TURNO),
    spostamento_errato(Strings.ERRORE_GENERICO + Strings.SPOSTAMENTO_ERRATO),
    presa_errata(Strings.ERRORE_GENERICO + Strings.PRESA_ERRATA),
    casella_vuota(Strings.ERRORE_GENERICO + Strings.MSG_CASELLA_VUOTA),
    pedina_avversaria(Strings.ERRORE_GENERICO + Strings.PEDINA_AVVERSARIA),
    posizione_out_of_range(Strings.ERRORE_GENERICO + Strings.POSIZIONE_OUT_OF_RANGE);

    /**
     * Stringhe contenenti le due parti del messaggio.
     */
    private final String msg1;
    private String msg2;

    /**
     * Costruttore dell'enumerativo Messaggio.
     * @param messaggio1 parte fissa del messaggio.
     */
      Messaggio(final String messaggio1) {
        this.msg1 = messaggio1;
        this.msg2 = "";
    }

    /**
     * Imposta la parte variabile del messaggio.
     * @param messaggio2 seconda parte del messaggio.
     */
    void setMsg(final String messaggio2) {
        this.msg2 = messaggio2;
    }

    /**
     * Restituisce il messaggio completo.
     * @return concatenazione delle due parti del messaggio.
     */
    public String getMsg() {
        return this.msg1 + this.msg2;
    }
}
