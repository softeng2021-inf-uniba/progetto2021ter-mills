package it.uniba.main.gioco;

import it.uniba.main.utilities.Observer;

public interface ObserverMessages extends Observer<Messaggio>
{
    @Override
    public void onChanged(Messaggio msg);
}
