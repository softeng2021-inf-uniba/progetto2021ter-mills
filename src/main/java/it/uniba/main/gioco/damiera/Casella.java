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
    private Pedina pedina;
    private TipoCasella tipo;

    public Casella(TipoCasella tipo)
    {
        this.pedina = null;
        this.tipo = tipo;
    }

    public void setTipoCasella(TipoCasella tipo)
    {
        this.tipo = tipo;
    }

    public Pedina getPedina()
    {
        return pedina;
    }

    public void setPedina(Pedina pedina)
    {
        this.pedina = pedina;
    }

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
