package it.uniba.main.utilities;


/**
 * <<Entity>>
 * Classe che tramite l uso di thread consente di
 * tenere traccia del tempo trascorso a partire dal suo avvio.
 * Essa consente anche di mettere in pausa e riprendere il conteggio.
 */

public class Cronometro implements Runnable
{
    private long ultimoTempoLetto;
    private long tempoTrascorso;

    private boolean isStarted;
    private boolean isPlaying;

    public Cronometro()
    {

    }


    public boolean riprendi()
    {
        boolean result = false;

        if (isStarted)
        {
            setUltimoTempoLetto(System.currentTimeMillis());
            setIsPlaying(true);
            result = true;
        }
        else
        {
            start();
        }

        return result;
    }


    public boolean pausa()
    {
        boolean result = false;

        if (getStarted())
        {
            setIsPlaying(false);
            result = true;
        }

        return result;
    }


    public void stop()
    {
        setStarted(false);
        setIsPlaying(false);
        setTempoTrascorso(0);
    }


    public boolean start()
    {
        boolean result = false;

        if (!getStarted())
        {
            setTempoTrascorso(0);
            setUltimoTempoLetto(System.currentTimeMillis());
            setStarted(true);
            setIsPlaying(true);

            Thread thread = new Thread(this);
            thread.start();

            result = true;
        }

        return result;
    }


    @Override
    public void run()
    {
        long temp;
        long newTempoTrascorso;

        while (getStarted())
        {
            try
            {
                if (getIsPlaying())
                {
                    temp = System.currentTimeMillis();
                    newTempoTrascorso = (temp - ultimoTempoLetto) + getTempoTrascorsoMillis();
                    setTempoTrascorso(newTempoTrascorso);
                    setUltimoTempoLetto(temp);
                }

                Thread.sleep(500);

            } catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }


    public synchronized long getTempoTrascorsoMillis()
    {
        return tempoTrascorso;
    }

    private boolean getStarted()
    {
        return isStarted;
    }

    private boolean getIsPlaying()
    {
        return isPlaying;
    }

    private synchronized void setIsPlaying(boolean value)
    {
        isPlaying = value;
    }

    private synchronized void setStarted(boolean value)
    {
        isStarted = value;
    }

    private synchronized void setTempoTrascorso(long value)
    {
        tempoTrascorso = value;
    }

    private synchronized void setUltimoTempoLetto(long value)
    {
        ultimoTempoLetto = value;
    }
}