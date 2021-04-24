package it.uniba.main.utilities;

public class Posizione
{
    public int x;
    public int y;

    public Posizione(int x, int y)
    {
        this.x = x;
        this.y = y;
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
            if (x == ((Posizione) o).x && y == ((Posizione) o).y)
            {
                return true;
            }
        }

        return false;
    }
}
