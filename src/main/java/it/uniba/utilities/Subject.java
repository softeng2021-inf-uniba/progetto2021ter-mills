package it.uniba.utilities;
import java.util.ArrayList;
import java.util.List;


/**
 * <<noECB>>
 * Classe soggetto per implementazione del pattern Observer.
 * @param <Tipo> tipo generico.
 */
public class Subject<Tipo> {
    /**
     * Lista degli observer in ascolto.
     */
    private List<Observer<Tipo>> observers = new ArrayList<>();

    /**
     * Lista degli observer da rimuovere.
     */
    private List<Observer<Tipo>> unregistered = new ArrayList<>();

    /**
     * Aggiungere l'observer alla lista degli observer attualmente in ascolto.
     * @param observer Observer da aggiungere.
     */
    public void register(final Observer<Tipo> observer) {
        observers.add(observer);
    }

    /**
     * Rimuove l'observer dalla lista degli observer in ascolto.
     * @param observer Observer da rimuovere.
     */
    public void unregister(final Observer<Tipo> observer) {
        unregistered.add(observer);
    }

    /**
     * Notifica tutti gli observer registrati al Subject.
     * @param arg Tipo generico da inoltrare agli observer.
     */
    public void notifyObservers(final Tipo arg) {
        observers.removeAll(unregistered);
        unregistered.clear();

        for (int i = 0; i < observers.size(); ++i) {
            observers.get(i).onChanged(arg);
        }
    }

}
