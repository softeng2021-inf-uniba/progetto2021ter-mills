package it.uniba.main.gioco.damiera;

import it.uniba.main.utilities.Strings;

public class Casella
{
    public enum TipoCasella
    {
        bianca,
        nera
    }

    private Pedina pedina;
    private TipoCasella tipo;

    public Casella(TipoCasella tipo)
    {
        this.pedina = null;
        this.tipo = tipo;
    }

    public TipoCasella getTipoCasella()
    {
        return tipo;
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
