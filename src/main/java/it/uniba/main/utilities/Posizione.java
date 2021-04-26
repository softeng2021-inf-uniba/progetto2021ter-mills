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


    public static Posizione differenza(Posizione pos1, Posizione pos2)
    {
        Posizione result = null;

        if (pos1 != null && pos2 != null)
        {
            int newX = pos1.x - pos2.x;
            int newY = pos1.y - pos2.y;
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
            if (x == ((Posizione) o).x && y == ((Posizione) o).y)
            {
                return true;
            }
        }

        return false;
    }
}
