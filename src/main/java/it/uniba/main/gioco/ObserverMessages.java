package it.uniba.main.gioco;

import it.uniba.main.utilities.Observer;


/**
 * <<noECB>>
 * interfaccia che eredita da Observer con argomento di tipo Messaggio
 */
public interface ObserverMessages extends Observer<Messaggio>
{
    @Override
    public void onChanged(Messaggio msg);
}
