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
    /**
     * Attributo di tipo TipoPedina chiamato tipo,
     * il quale rappresenta il colore della pedina (bianco o nero).
     */
    private TipoPedina tipo;

    /**
     * Attributo di tipo Posizione chiamato posizione,
     * il quale rappresenta la posizione della pedina nella dama.
     */
    public Posizione posizione;

    /**
     * attributo di tipo booleano chiamato isDama,
     * il quale rappresenterà se una pedina è Dama o meno.
     */
    public boolean isDama;


    /**
     * Costruttore della classe Pedina.
     * @param tipo determina il tipo della pedina.
     * @param posizione determina la posizione della pedina.
     */
    public Pedina(TipoPedina tipo, Posizione posizione)
    {
        this.tipo = tipo;
        this.posizione = posizione;
        this.isDama = false;
    }

    /**
     * Metodo getter del tipo della pedina.
     * @return il tipo della pedina.
     */

    public TipoPedina getTipo()
    {
        return tipo;
    }

    /**
     * Metodo getter della direzione della pedina.
     * @return la direzione della pedina, se è bianca si muove
     * verso l'alto della matrice (-1) altrimenti verso il basso (1).
     */
    public int getDirezione()
    {
        return tipo == TipoPedina.bianca ? -1 : 1;
    }

    /**
     * Metodo toString della classe Pedina
     * @return una controlla se la pedina è dama e ne restituisce il
     * carattere unicode della dama (bianca o nero),
     * altrimenti restituisce l'unicode della pedina (bianca o nera).
     */

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