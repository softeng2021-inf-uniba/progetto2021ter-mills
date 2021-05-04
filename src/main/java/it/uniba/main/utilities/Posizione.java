package it.uniba.main.utilities;


/**
 * <<noECB>>
 * Classe che rappresenta le coordinate di una matrice.
 * Essa consente anche di calcolare la differenza tra due posizioni.
 */
public class Posizione
{
    public int riga;
    public int colonna;

    public Posizione(int riga, int colonna)
    {
        this.riga = riga;
        this.colonna = colonna;
    }


    public static Posizione differenza(Posizione pos1, Posizione pos2)
    {
        Posizione result = null;

        if (pos1 != null && pos2 != null)
        {
            int newX = pos1.riga - pos2.riga;
            int newY = pos1.colonna - pos2.colonna;
            result = new Posizione(newX, newY);
        }

        return result;
    }


    @Override
    public boolean equals(Object o)
    {
        if (o == this)
        {
            return true;
        }

        if (o instanceof Posizione)
        {
            if (riga == ((Posizione) o).riga && colonna == ((Posizione) o).colonna)
            {
                return true;
            }
        }

        return false;
    }
}
