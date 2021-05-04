package it.uniba.main.gioco;

import it.uniba.main.utilities.Observer;


/**
 * <<noECB>>
 * interfaccia che eredita da Observer con argomento di tipo Status
 */
public interface ObserverStatus extends Observer<Status>
{
    @Override
    public void onChanged(Status status);
}
