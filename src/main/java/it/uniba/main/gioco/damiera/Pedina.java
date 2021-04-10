package it.uniba.main.gioco.damiera;

import it.uniba.main.utilities.Posizione;

public class Pedina
{
    public enum TipoPedina
    {
        nera,
        bianca
    }

    private TipoPedina tipo;
    public Posizione posizione;
    public boolean isDama;


    public Pedina(TipoPedina tipo, Posizione posizione)
    {
        this.tipo = tipo;
        this.posizione = posizione;
        this.isDama = false;
    }

    public TipoPedina getTipo()
    {
        return tipo;
    }

    public int getDirezione()
    {
        return tipo == TipoPedina.bianca ? 1 : -1;
    }

    @Override
    public String toString()
    {
        String result = "";
        if (isDama)
        {
            result = (tipo == TipoPedina.bianca) ? "B " : "N "; //Utilities.PEDINA_REGINA_BIANCA : Utilities.PEDINA_REGINA_NERA;
        }
        else
        {
            result = (tipo == TipoPedina.bianca) ? "b " : "n "; //Utilities.PEDINA_BIANCA : Utilities.PEDINA_NERA;
//            result += (tipo == TipoPedina.bianca) ? Strings.PEDINA_BIANCA + " " : Strings.PEDINA_NERA + " "; //Utilities.PEDINA_BIANCA : Utilities.PEDINA_NERA;
        }
        return result;
    }
}