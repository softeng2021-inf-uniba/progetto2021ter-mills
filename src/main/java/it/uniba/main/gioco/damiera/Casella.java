package it.uniba.main.gioco.damiera;

import it.uniba.main.utilities.Strings;

public class Casella {
    public enum TipoCasella {
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

    public TipoCasella getTipoCasella() {
        return tipo;
    }

    public void setTipoCasella(TipoCasella tipo) {
        this.tipo = tipo;
    }

    public Pedina getPedina() {
        return pedina;
    }

    public void setPedina(Pedina pedina) {
        this.pedina = pedina;
    }

    @Override
    public String toString()
    {
        String result = "";
        if (pedina != null)
        {
            result += pedina.toString();
        }
        else result += Strings.CASELLA_VUOTA;
        return result;
    }
}
