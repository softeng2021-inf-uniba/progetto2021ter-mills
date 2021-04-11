package it.uniba.main.utilities;

public class Cronometro implements Runnable
{
    private long ultimoTempoLetto;
    private long tempoTrascorso;

    private boolean started;
    private boolean isPlaying;

    Thread thread;

    public Cronometro() { }


    public boolean riprendi()
    {
        boolean result = false;

        if (started)
        {
            isPlaying = true;

            ultimoTempoLetto = System.currentTimeMillis();

            result = true;
        }

        return result;
    }


    public boolean pausa()
    {
        boolean result = false;

        if (started)
        {
            isPlaying = false;

            result = true;
        }

        return result;
    }


    public void stop()
    {
        started = false;
        isPlaying = false;
        tempoTrascorso = 0;

        if (thread != null)
        {
            thread.stop();
        }

    }


    public boolean start()
    {
        boolean result = false;

        if (!started)
        {
            tempoTrascorso = 0;
            started = true;
            isPlaying = true;
            ultimoTempoLetto = System.currentTimeMillis();

            Thread thread = new Thread(this);
            thread.start();

            result = true;
        }

        return result;
    }


    public long getTempoTrascorsoMillis()
    {
        return tempoTrascorso;
    }


    @Override
    public void run()
    {
        while(started)
        {
            try
            {
                if (isPlaying)
                {
                    tempoTrascorso += System.currentTimeMillis() - ultimoTempoLetto;
                    ultimoTempoLetto = System.currentTimeMillis();
                }

                Thread.sleep(500);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }
}