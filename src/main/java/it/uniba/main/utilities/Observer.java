package it.uniba.main.utilities;


/**
 * <noECB>
 *   Interfaccia generica per observer.
 * @param <Tipo> Observer di un tipo generico.
 */

public interface Observer<Tipo> {
     void onChanged(Tipo arg);
}

