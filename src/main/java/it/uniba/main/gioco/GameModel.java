package it.uniba.main.gioco;

import it.uniba.main.gioco.damiera.Casella;
import it.uniba.main.gioco.damiera.Damiera;
import it.uniba.main.gioco.damiera.Pedina;
import it.uniba.main.utilities.Cronometro;
import it.uniba.main.utilities.Posizione;
import it.uniba.main.utilities.Strings;
import it.uniba.main.utilities.Subject;

public class GameModel
{
    private Damiera damiera;
    private boolean isPlaying;
    private boolean isTurnoBianco;
    private Cronometro cronometroBianco;
    private Cronometro cronometroNero;


    private int dimDamiera;

    private Status status;
    private Subject<Status> onStatusChanged;



    public GameModel(int dimDamiera)
    {
        onStatusChanged = new Subject<>();
        this.dimDamiera = dimDamiera;
        //TODO
    }


    public void startGame()
    {
        damiera = new Damiera(dimDamiera);
        if(cronometroBianco != null)
        {
            cronometroBianco.stop();
            cronometroNero.stop();
        }
        else
        {
            cronometroBianco = new Cronometro();
            cronometroNero = new Cronometro();
        }
        isTurnoBianco = true;
        isPlaying = true;
        cronometroBianco.start();
        setStatus(Status.partita_iniziata);
    }

    /*private Pedina tryGetPedina(Posizione posPedina)
    {
        Pedina pedina = null;
        if (posPedina == null)
        {
            notificaMessaggio(Messaggio.comando_errato);
        }
        else
        {
            if (damiera.isPosizioneValida(posPedina))
            {
                pedina = damiera.getPedina(posPedina);
                if (!damiera.isPedinaValida(pedina, isTurnoBianco))
                {
                    pedina = null;
                    notificaMessaggio(Messaggio.inserimento_errato);
                }
            }
            else
            {
                notificaMessaggio(Messaggio.posizione_out_of_range);
            }
        }
        return pedina;
    }*/

    public void eseguiMossa(Posizione partenza, Posizione arrivo)
    {

    }

    public void abbandonaPartita()
    {
        Status.partita_terminata.setMsg(isTurnoBianco ? Strings.GIOCATORE_NERO : Strings.GIOCATORE_BIANCO);
        setStatus(Status.partita_terminata);
        isPlaying = false;
    }

    public void setStatus(Status status)
    {
        this.status = status;
        onStatusChanged.notifyObservers(status);
    }

    public boolean getIsPlaying(){
        return isPlaying;
    }

    public Subject<Status> getOnStatusChanged()
    {
        return onStatusChanged;
    }

    public Casella[][] getDamiera()
    {
        return damiera.getDamiera();
    }

    public int getDimDamiera()
    {
        return dimDamiera;
    }

    public Cronometro getCronometroBianco()
    {
        return cronometroBianco;
    }

    public Cronometro getCronometroNero()
    {
        return cronometroNero;
    }

}
