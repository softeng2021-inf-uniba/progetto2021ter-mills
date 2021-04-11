package it.uniba.main.gioco;

import it.uniba.main.gioco.damiera.Casella;
import it.uniba.main.gioco.damiera.Damiera;
import it.uniba.main.utilities.Strings;
import it.uniba.main.utilities.Subject;

public class GameModel
{
    private Damiera damiera;
    private boolean isPlaying;
    private boolean isTurnoBianco;


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
        isPlaying = true;
        isTurnoBianco = true;
        setStatus(Status.partita_iniziata);
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

}
