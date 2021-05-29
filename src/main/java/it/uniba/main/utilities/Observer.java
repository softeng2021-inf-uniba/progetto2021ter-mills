package it.uniba.main.utilities;


/**
 * <noECB>
 *   Interfaccia generica per observer.
 * @param <Tipo> Observer di un tipo generico.
 */

public interface Observer<Tipo> {

     /**
      * Azione da eseguire quando l observer viene notificato da un soggetto a cui si è registrato.
      * @param arg argomento (generico) ricevuto dal soggetto.
      */
     void onChanged(Tipo arg);
}

