package it.uniba.main.gioco.damiera;

import it.uniba.main.utilities.Posizione;
import it.uniba.main.utilities.Strings;

/**
 * <<Entity>>
 * Classe che rappresenta la pedina.
 * Inoltre al suo interno è contenuto l'enumerativo che stabilisce il colore della pedina.
 */

public class Pedina
{
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
        return tipo == TipoPedina.bianca ? -1 : 1;
    }

    @Override
    public String toString()
    {
        String result = "";
        if (isDama)
        {
            result += (tipo == TipoPedina.bianca) ? Strings.PEDINA_REGINA_BIANCA : Strings.PEDINA_REGINA_NERA;
        }
        else
        {
            result += (tipo == TipoPedina.bianca) ? Strings.PEDINA_BIANCA : Strings.PEDINA_NERA;
        }
        return result;
    }
}