package it.uniba.main.gioco.damiera;

import it.uniba.main.utilities.Strings;

/**
 * <<Entity>>
 * Classe che rappresenta la casella. Essa si occupa della gestione della pedina contenuta
 * nella determinata casella. Inoltre al suo interno è contenuto l'enumerativo che stabilisce il colore
 * della casella.
 */

public class Casella
{
    /**
     * Attributo di tipo Pedina chiamato pedina,
     * utilizzato per salvare la reference della pedina nella casella
     */
    private Pedina pedina;

    /**
     * Attributo di tipo TipoCasella chiamato tipo,
     * rappresentante la tipologia della casella (bianca o nera)
     */
    private TipoCasella tipo;

    /**
     * Costruttore della classe Casella
     * @param tipo determina il tipo della casella
     */
    public Casella(TipoCasella tipo)
    {
        this.pedina = null;
        this.tipo = tipo;
    }

    /**
     * Metodo setter del tipo della casella
     * @param tipo stabilisce il tipo della casella (bianca o nera)
     */
    public void setTipoCasella(TipoCasella tipo)
    {
        this.tipo = tipo;
    }

    /**
     * Metodo getter della pedina presente nella casella
     * @return ritorna la reference della pedina salvata nella casella
     */
    public Pedina getPedina()
    {
        return pedina;
    }

    /**
     * Metodo setter della pedina.
     * Salva la reference della pedina passata
     * @param pedina è la variabile di tipo pedina da memorizzare
     */
    public void setPedina(Pedina pedina)
    {
        this.pedina = pedina;
    }

    /**
     * Metodo toString della classe casella
     * @return una stringa rappresentante il colore della casella, e se esistente la pedina associata
     */
    @Override
    public String toString()
    {
        String result = "";

        result += (tipo == TipoCasella.bianca) ? Strings.RGB_CREMA_BG : Strings.RGB_INDACO_BG;
        result += " ";
        result += (pedina != null) ? pedina.toString() : Strings.CASELLA_VUOTA;
        result += " ";
        result += Strings.ANSI_RESET;

        return result;
    }

}
