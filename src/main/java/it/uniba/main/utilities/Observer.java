package it.uniba.main.utilities;


/**
 * <<noECB>>
 * interfaccia generica per observer
 */
public interface Observer<Tipo>
{
    public void onChanged(Tipo arg);
}

