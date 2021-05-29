
package it.uniba.main.utilities;


/**
 * <<Entity>>
 * Classe che tramite l'uso di thread consente di
 * tenere traccia del tempo trascorso a partire dal suo avvio.
 * Essa consente anche di mettere in pausa e riprendere il conteggio.
 */

public class Cronometro implements Runnable {
    /**
     * ultimo tempo acquisito.
     */
    private long ultimoTempoLetto;

    /**
     * tempo trascorso.
     */
    private long tempoTrascorso;

    /**
     *  vale true se il cronotometro e' stato avviato, altrimenti false.
     */
    private boolean isStarted;

    /**
     * vale true se il cronotometro e' in esecuzione, altrimenti false.
     */
    private boolean isPlaying;

    /**
     * Costruttore della classe.
     */
    public Cronometro() {
    }


    /**
     * Riprende l'esecuzione del cronometro.
     * @return restituisce true se il cronometro ha ripreso a registrare i valori correttamente, altrimenti false.
     */
    public boolean riprendi() {
        boolean result = false;

        if (isStarted) {
            setUltimoTempoLetto(System.currentTimeMillis());
            setIsPlaying(true);
            result = true;
        } else {
            start();
        }

        return result;
    }


    /**
     * Mette in pausa il cronometro interrompendo l'acquisizione di nuovi valori.
     * @return restituisce true se il cronometro e' stato messo in pausa correttamente.
     */
    public boolean pausa() {
        boolean result = false;

        if (getStarted()) {
            setIsPlaying(false);
            result = true;
        }

        return result;
    }


    /**
     * Interrompe l'esecuzione del cronometro e reimposta i valori.
     */
    public void stop() {
        setStarted(false);
        setIsPlaying(false);
        setTempoTrascorso(0);
    }


    /**
     * Inizializza e starta il cronometro.
     * @return true se il cronometro è stato avviato.
     */
    public boolean start() {
        boolean result = false;

        if (!getStarted()) {
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


    /**
     * Override del metodo run di runnable.
     * Implementa la logica di acquisizione del tempo.
     */
    @Override
    public void run() {
        final long awaitTime = 500;
        long temp;
        long newTempoTrascorso;

        while (getStarted()) {
            try {
                if (getIsPlaying()) {
                    temp = System.currentTimeMillis();
                    newTempoTrascorso = (temp - ultimoTempoLetto) + getTempoTrascorsoMillis();
                    setTempoTrascorso(newTempoTrascorso);
                    setUltimoTempoLetto(temp);
                }

                Thread.sleep(awaitTime);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    /**
     * Restituisce il tempo trascorso in millisecondi.
     * @return il tempo trascorso in millisecondi.
     */
    public synchronized long getTempoTrascorsoMillis() {
        return tempoTrascorso;
    }

    /**
     * Restituisce la variabile isStarted.
     * @return vero se è stato avviato il cronometro, falso altrimenti.
     */
    private boolean getStarted() {
        return isStarted;
    }

    /**
     * Restituisce true se il cronometro e' in esecuzione, altrimenti false.
     * @return true se il cronometro e' in esecuzione, altrimenti false.
     */
    private boolean getIsPlaying() {
        return isPlaying;
    }

    /**
     * Setter della variabile isPlaying.
     * @param value valore che verra' impostato alla variabile isPlaying.
     */
    private synchronized void setIsPlaying(final boolean value) {
        isPlaying = value;
    }

    /**
     * Setter della variabile isStarted.
     * @param value valore che verra' impostato alla variabile isStarted.
     */
    private synchronized void setStarted(final boolean value) {
        isStarted = value;
    }

    /**
     * Setter della variabile tempoTrascorso.
     * @param value valore che verra' impostato alla variabile tempoTrascorso.
     */
    private synchronized void setTempoTrascorso(final long value) {
        tempoTrascorso = value;
    }

    /**
     * Setter della variabile ultimoTempoLetto.
     * @param value valore che verra' impostato alla variabile ultimoTempoLetto.
     */
    private synchronized void setUltimoTempoLetto(final long value) {
        ultimoTempoLetto = value;
    }
}
