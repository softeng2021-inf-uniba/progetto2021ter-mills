package it.uniba.main.gioco;

import it.uniba.main.utilities.Observer;

public interface ObserverStatus extends Observer<Status>
{
    @Override
    public void onChanged(Status status);
}
