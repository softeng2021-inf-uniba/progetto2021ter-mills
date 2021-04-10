package it.uniba.main.utilities;

public class Posizione
{
    public int riga;
    public int colonna;

    public Posizione(int riga, int colonna)
    {
        this.riga = riga;
        this.colonna = colonna;
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
