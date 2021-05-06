package it.uniba.main.gioco;

import it.uniba.main.utilities.Strings;

/** <<noECB>>
 * Enumerativo che contiene i vari messaggi possibili.
 */

public enum Messaggio
{
    errore_generico(Strings.ERRORE_GENERICO),
    eseguita(Strings.MOSSA_ESEGUITA),
    cambio_giocatore(Strings.CAMBIO_TURNO),
    spostamento_errato(Strings.ERRORE_GENERICO + Strings.SPOSTAMENTO_ERRATO),
    presa_errata(Strings.ERRORE_GENERICO + Strings.PRESA_ERRATA),
    casella_vuota(Strings.ERRORE_GENERICO + Strings.MSG_CASELLA_VUOTA),
    pedina_avversaria(Strings.ERRORE_GENERICO + Strings.PEDINA_AVVERSARIA),
    posizione_out_of_range(Strings.ERRORE_GENERICO + Strings.POSIZIONE_OUT_OF_RANGE);

    private final String msg1;
    private String msg2;

    private Messaggio(String msg1)
    {
        this.msg1 = msg1;
        this.msg2 = "";
    }
    private Messaggio(String msg1, String msg2)
    {
        this.msg1 = msg1;
        this.msg2 = msg2;
    }

    public void setMsg(String msg2)
    {
        this.msg2 = msg2;
    }

    public String getMsg()
    {
        return this.msg1 + this.msg2;
    }
}
