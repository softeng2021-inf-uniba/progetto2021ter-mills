package it.uniba.main.gioco.damiera;

import it.uniba.main.utilities.Posizione;
import it.uniba.main.utilities.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * <<Entity>>
 * Classe che rappresenta la damiera. Essa si occupa della gestione delle caselle, delle pedine, dei loro spostamenti
 * e delle prese.
 */

public class Damiera
{
    /**
     * Dimensione della damiera
     */
    private final int DIM;
    /**
     * Array multidimensionale che rappresenta le caselle della damiera
     */
    private Casella[][] damiera;

    /**
     * Lista delle pedine bianche presenti
     */
    private List<Pedina> listaPedineBianche;

    /**
     * Lista delle pedine nere presenti
     */
    private List<Pedina> listaPedineNere;

    /**
     * Costruttore della classe Damiera
     * @param dim valore intero rappresentante la dimensione della damiera (dim x dim)
     */
    public Damiera(int dim)
    {
        this.DIM = dim;
        init();
    }

    /**
     * Metodo utilizato per inizializzare lo stato delle caselle e delle pedine
     * contenute nella damiera
     */
    public void init()
    {
        setupCaselle();
        setupPedine();
    }

    /**
     * Metodo che inizializza le caselle presenti nella damiera
     */
    private void setupCaselle()
    {
        damiera = new Casella[DIM][DIM];

        for (int i = 0; i < DIM; i++)
        {
            for (int j = 0; j < DIM; j++)
            {
                damiera[i][j] = new Casella(TipoCasella.bianca);
                if (((i * (DIM + 1) + j) % 2) == 0)
                {
                    damiera[i][j].setTipoCasella(TipoCasella.nera);
                }
            }
        }
    }

    /**
     * Metodo che inizializza le pedine presenti nella damiera
     */
    private void setupPedine()
    {
        listaPedineBianche = new ArrayList<>();
        listaPedineNere = new ArrayList<>();

        //Posizionamento pedine nere
        for (int i = 0; i < 3; i++)
        {
            for (int j = i % 2; j < DIM; j += 2)
            {
                Pedina pedina = new Pedina(TipoPedina.nera, new Posizione(i, j));
                damiera[i][j].setPedina(pedina);
                listaPedineBianche.add(pedina);
            }
        }

        //Posizionamento pedine bianche
        for (int i = DIM - 3; i < DIM; i++)
        {
            for (int j = i % 2; j < DIM; j += 2)
            {
                Pedina pedina = new Pedina(TipoPedina.bianca, new Posizione(i, j));
                damiera[i][j].setPedina(pedina);
                listaPedineNere.add(pedina);
            }
        }
    }

    /**
     * Funzione che stabilisce se una deterinata posizone è valida o meno
     * @param posizione variabile di tipo posizione passato nella funzione
     * @return la funzione ritorna true se la posizione passata è valida, false altrimenti
     */
    public boolean isPosizioneValida(Posizione posizione)
    {
        return posizione.riga >= 0 && posizione.riga < DIM && posizione.colonna >= 0 && posizione.colonna < DIM;
    }

    /**
     * Funzione che stabilisce se una deterinata pedina è valida o meno
     * @param pedina variabile di tipo pedina passato nella funzione
     * @param isTurnoBianco variabile che permette di stabilire il turno del giocatore (bianco o nero)
     * @return restituisce true se la pedina passata è valida, false altrimenti
     */
    public boolean isPedinaValida(Pedina pedina, boolean isTurnoBianco)
    {
        boolean result = false;

        if (pedina != null)
        {
            if ((isTurnoBianco && pedina.getTipo() == TipoPedina.bianca) || (!isTurnoBianco && pedina.getTipo() == TipoPedina.nera))
            {
                result = true;
            }
        }

        return result;
    }

    /**
     * Funzione che serve per ottenere la reference ad una determinata pedina contenuta nella damiera in base alla
     * posizone passata
     * @param pos variabile di tipo pozione che serve per stabilire quale pedina della damiera deve essere restituita
     * @return viene restituita una pedina nella quale è salvata la reference di una certa pedina presente nella damiera
     */
    public Pedina getPedina(Posizione pos)
    {
        Pedina pedina = null;
        if (isPosizioneValida(pos))
        {
            pedina = damiera[pos.riga][pos.colonna].getPedina();
        }
        return pedina;
    }

    /**
     * Funzione che serve per stabilire se uno spostamento semplice è attuabile o meno
     * @param pedina variabile di tipo Pedina che rappresenta la pedina che deve essere spostata
     * @param nuovaPosizione variabile di tipo posizone che rappresenta la nuova posizione che si vuole far
     *                       raggiungere alla pedina
     * @return la funzioone ritorna true se lo spostamento viene effettuato, false altrimenti
     */
    public boolean trySpostamentoSemplice(Pedina pedina, Posizione nuovaPosizione)
    {
        boolean result = false;

        if (isPosizioneValida(nuovaPosizione))
        {
            result = spostamentoSemplice(pedina, nuovaPosizione);
        }

        return result;
    }

    /**
     * Funzione che serve per effettuare una determinata presa
     * @param partenza posizione di partenza della pedina
     * @param arrivo posizione di arrivo della pedina (dopo la presa)
     * @param pedina pedina che effettua la presa
     * @return Se la presa viene effettuata viene restituita la pedina che viene mangiata
     */
    private Pedina checkPresa(Posizione partenza, Posizione arrivo, Pedina pedina)
    {
        Pedina result = null;

        if (isPosizioneValida(partenza) && isPosizioneValida(arrivo))
        {
            if (damiera[arrivo.riga][arrivo.colonna].getPedina() == null)
            {
                Posizione differenza = Posizione.differenza(arrivo, partenza);

                if (differenza.riga * pedina.getDirezione() == 2 && Math.abs(differenza.colonna) == 2)
                {
                    int rigaAvversaria = partenza.riga + pedina.getDirezione();
                    int colonnaAvversaria = partenza.colonna + differenza.colonna / 2;

                    Pedina avversaria = damiera[rigaAvversaria][colonnaAvversaria].getPedina();

                    if (avversaria != null && avversaria.getTipo() != pedina.getTipo())
                    {
                        result = avversaria;
                    }
                }
            }

        }

        return result;
    }

    /**
     * Funzione che serve per stabilire se una presa (singola o multipla) è attuabile o meno
     * @param posizioni lista di posizoni contenente la posizione inziale e tutte le eventuali posizioni che la
     *                  pedina deve raggiungere per effettuare le varie prese
     * @return viene restituita una lista di pedine mangiate
     */
    public List<Pedina> tryPresa(List<Posizione> posizioni)
    {
        boolean result = true;
        List<Pedina> pedinePrese = new ArrayList<>();
        Pedina pedina = damiera[posizioni.get(0).riga][posizioni.get(0).colonna].getPedina();

        for (int i = 0; i < posizioni.size() - 1 && result; i++)
        {
            Pedina temp = checkPresa(posizioni.get(i), posizioni.get(i+1), pedina);
            if (temp != null)
            {
                pedinePrese.add(temp);
            }
            else
            {
                pedinePrese.clear();
                result = false;
            }
        }

        if (result)
        {
            for(int i = 0; i < pedinePrese.size(); i++)
            {
                damiera[pedinePrese.get(i).posizione.riga][pedinePrese.get(i).posizione.colonna].setPedina(null);
            }

            setPosizionePedina(pedina, posizioni.get(posizioni.size()-1));
        }

        return pedinePrese;
    }

    /**
     * Funzione che effettua uno spostamento semplice
     * @param pedina variabile di tipo Pedina che rappresenta la pedina che si vuole spostare
     * @param nuovaPosizione variabile di tipo Posizone che rappresenta la posizione
     * @return la funzione ritorna true se lo spostamento viene effettuato, false altrimenti
     */
    private boolean spostamentoSemplice(Pedina pedina, Posizione nuovaPosizione)
    {
        boolean result = false;

        Casella nuovaCasella = damiera[nuovaPosizione.riga][nuovaPosizione.colonna];

        if (nuovaCasella.getPedina() == null)
        {
            int distanzaSpostamentoY = (nuovaPosizione.riga - pedina.posizione.riga) * pedina.getDirezione();

            int distanzaSpostamentoX = Math.abs(nuovaPosizione.colonna - pedina.posizione.colonna);

            if (distanzaSpostamentoY == 1 && distanzaSpostamentoX == 1)
            {
                setPosizionePedina(pedina, nuovaPosizione);
                result = true;
            }
        }

        return result;
    }

    /**
     * Metodo che serve per impostare
     * @param pedina variabile di tipo Pedina che rappresenta la pedina della quale si vuole cambiare la posizione
     * @param nuovaPosizione variabile di tipo Posizione che rappresenta la posizone che si vuole impostare alla
     *                       pedina passata
     */
    private void setPosizionePedina(Pedina pedina, Posizione nuovaPosizione)
    {
        if (pedina.getDirezione() == 1 && nuovaPosizione.riga == DIM - 1)
        {
            pedina.isDama = true;
            System.out.println(Strings.AVVISO_DAMATURA);
        }
        else if (pedina.getDirezione() == -1 && nuovaPosizione.riga == 0)
        {
            pedina.isDama = true;
            System.out.println(Strings.AVVISO_DAMATURA);
        }
        damiera[pedina.posizione.riga][pedina.posizione.colonna].setPedina(null);
        damiera[nuovaPosizione.riga][nuovaPosizione.colonna].setPedina(pedina);

        pedina.posizione = nuovaPosizione;
    }

    /**
     * Funzione toString della classe Damiera
     * @return ritorna una stringa contenente lo stato attuale della damiera
     */
    @Override
    public String toString()
    {
        StringBuffer stringa = new StringBuffer();

        for (int riga = 0; riga < damiera.length; riga++)
        {
            for (int colonna = 0; colonna < damiera.length; colonna++)
            {
                stringa.append(damiera[riga][colonna].toString());
            }
            stringa.append("\n");
        }
        return stringa.toString();
    }
}
