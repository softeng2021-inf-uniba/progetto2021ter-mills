package it.uniba.main.gioco;

import it.uniba.main.gioco.damiera.Casella;
import it.uniba.main.gioco.damiera.Damiera;
import it.uniba.main.utilities.Subject;

public class GameModel
{
    private Damiera damiera;
    private boolean isPlaying;

    private Status status;
    private Subject<Status> onStatusChanged;



    public GameModel()
    {
        onStatusChanged = new Subject<>();
        //TODO
    }


    public void startGame()
    {
        setStatus(Status.partita_iniziata);
        damiera = new Damiera(8);
        isPlaying = true;
    }

    public void setStatus(Status status)
    {
        status = Status.partita_iniziata;
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
}
