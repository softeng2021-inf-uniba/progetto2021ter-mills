package it.uniba.main.utilities;

import java.util.ArrayList;
import java.util.List;


/**
 * <<noECB>>
 * Classe soggetto per implementazione del pattern Observer
 */
public class Subject<Tipo>
{
    private List<Observer<Tipo>> observers = new ArrayList<>();
    private List<Observer<Tipo>> unregistered = new ArrayList<>();

    public void register(Observer<Tipo> observer)
    {
        observers.add(observer);
    }

    public void unregister(Observer<Tipo> observer)
    {
        unregistered.add(observer);
    }

    public void notifyObservers(Tipo arg)
    {
        observers.removeAll(unregistered);
        unregistered.clear();

        for (int i = 0; i < observers.size(); ++i)
        {
            observers.get(i).onChanged(arg);
        }
    }

}