package it.uniba.main.gioco;

import it.uniba.main.utilities.Strings;


/** <<noECB>>
 * Enumerativo che rappresenta gli stati possibili
 * e ne contiene una descrizione costituita da due parti.
 */

public enum Status
{
    /**
     * Status utilizzati durante la partita.
     */
    partita_iniziata(Strings.INIZIO_PARTITA),
    partita_terminata(Strings.FINE_PARTITA);

    /**
     * Stringhe contenenti le due parti della descrizione dello Status.
     */
    private final String msg1;
    private String msg2;

    /**
     * Costruttore dell'enumerativo Status.
     * @param msg1 prima parte della descrizione dello Status.
     */
    private Status(String msg1)
    {
        this.msg1 = msg1;
        this.msg2 = "";
    }

    /**
     * Imposta la seconda parte della descrizione dello Status.
     * @param msg2 seconda parte della descrizione dello Status.
     */
    void setMsg(String msg2)
    {
        this.msg2 = msg2;
    }

    /**
     * Restituisce la descrizione completa dello Status.
     * @return concatenazione delle due parti della descrizione dello Status.
     */
    public String getMsg()
    {
        return this.msg1 + this.msg2;
    }
}