package it.uniba.gioco.damiera;

import it.uniba.utilities.Posizione;

import java.util.ArrayList;
import java.util.List;

/**
 * <<Entity>>
 * Classe che rappresenta la damiera.
 * Essa si occupa della gestione delle caselle,
 * delle pedine, dei loro spostamenti e delle prese.
 */

public class Damiera {
    /**
     * Costante delle righe popolate.
     */
    private static final int INIT_RIGHE_POPOLATE = 3;
    /**
     * Dimensione della damiera.
     */
    private final int dim;
    /**
     * Array multidimensionale di elementi di tipo Casella, che rappresenta la damiera.
     */
    private Casella[][] damiera;

    /**
     * Lista delle pedine bianche presenti sulla damiera.
     */
    private List<Pedina> listaPedineBianche;

    /**
     * Lista delle pedine nere presenti sulla damiera.
     */
    private List<Pedina> listaPedineNere;

    /**
     * Costruttore della classe Damiera.
     *
     * @param dimensione lunghezza lato damiera (dim x dim).
     */
    public Damiera(final int dimensione) {
        this.dim = dimensione;
        init();
    }


    /**
     * Inizializza lo stato delle caselle e delle pedine
     * contenute nella damiera.
     */
    public void init() {
        setupCaselle();
        setupPedine();
    }

    /**
     * Inizializza le caselle presenti nella damiera.
     */
    private void setupCaselle() {
        damiera = new Casella[dim][dim];

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                damiera[i][j] = new Casella(TipoCasella.bianca);
                if (((i * (dim + 1) + j) % 2) == 0) {
                    damiera[i][j].setTipoCasella(TipoCasella.nera);
                }
            }
        }
    }

    /**
     * Inizializza le pedine presenti nella damiera.
     */
    private void setupPedine() {
        listaPedineBianche = new ArrayList<>();
        listaPedineNere = new ArrayList<>();

        //Posizionamento pedine nere
        for (int i = 0; i < INIT_RIGHE_POPOLATE; i++) {
            for (int j = i % 2; j < dim; j += 2) {
                Pedina pedina = new Pedina(TipoPedina.nera, new Posizione(i, j));
                damiera[i][j].setPedina(pedina);
                listaPedineBianche.add(pedina);
            }
        }

        //Posizionamento pedine bianche
        for (int i = dim - INIT_RIGHE_POPOLATE; i < dim; i++) {
            for (int j = i % 2; j < dim; j += 2) {
                Pedina pedina = new Pedina(TipoPedina.bianca, new Posizione(i, j));
                damiera[i][j].setPedina(pedina);
                listaPedineNere.add(pedina);
            }
        }
    }

    /**
     * Verifica se una posizione si trova all'interno del range
     * dei valori consentiti.
     *
     * @param posizione posizione da valutare.
     * @return ritorna true se la posizione passata è valida, altrimenti false.
     */
    public boolean isPosizioneValida(final Posizione posizione) {
        return posizione.getRiga() >= 0 && posizione.getRiga() < dim && posizione.getColonna()
            >= 0 && posizione.getColonna() < dim;
    }

    /**
     * Verifica che la pedina passata sia del TipoPedina consentito durante il turno corrente.
     *
     * @param pedina variabile di tipo pedina passato nella funzione.
     *
     * @param isTurnoBianco variabile che permette di stabilire il turno del giocatore (bianco o nero).
     *
     * @return restituisce true se la pedina passata è valida nel turno corrente, altrimenti false.
     */
    public boolean isPedinaValida(final Pedina pedina, final boolean isTurnoBianco) {
        boolean result = false;

        if (pedina != null) {
            if ((isTurnoBianco && pedina.getTipo() == TipoPedina.bianca) || (
                !isTurnoBianco && pedina.getTipo() == TipoPedina.nera)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Restituisce la pedina che si trova nella posizione "pos".
     *
     * @param pos posizione nella quale si trova la pedina da restituire.
     *
     * @return restituisce la pedina nella posizione "pos" se quest'ultima e' valida e contiene una pedina,
     * altrimenti null.
     */
    public Pedina getPedina(final Posizione pos) {
        Pedina pedina = null;
        if (isPosizioneValida(pos)) {
            pedina = damiera[pos.getRiga()][pos.getColonna()].getPedina();
        }
        return pedina;
    }

    /**
     * Controlla se uno spostamento semplice è fattibile o meno.
     *
     * @param pedina pedina da spostare.
     *
     * @param nuovaPosizione posizione nella quale va spostata la pedina.
     *
     * @return ritorna true se lo spostamento viene effettuato, altrimenti false.
     */
    public boolean trySpostamentoSemplice(final Pedina pedina, final Posizione nuovaPosizione) {
        boolean result = false;

        if (isPosizioneValida(nuovaPosizione)) {
            result = spostamentoSemplice(pedina, nuovaPosizione);
        }
        return result;
    }

    /**
     * Controlla se una presa e' fattibile.
     *
     * @param partenza posizione di partenza della pedina.
     *
     * @param arrivo posizione di arrivo della pedina (dopo la presa).
     *
     * @param pedina pedina che effettua la presa.
     *
     * @return se la presa e' fattibile viene restituita la pedina che viene mangiata, altrimenti null.
     */
    private Pedina checkPresa(final Posizione partenza, final Posizione arrivo, final Pedina pedina) {
        Pedina result = null;

        if (isPosizioneValida(partenza) && isPosizioneValida(arrivo)) {
            if (damiera[arrivo.getRiga()][arrivo.getColonna()].getPedina() == null) {
                Posizione differenza = Posizione.differenza(arrivo, partenza);

                if (differenza.getRiga() * pedina.getDirezione() == 2 && Math.abs(differenza.getColonna()) == 2) {
                    int rigaAvversaria = partenza.getRiga() + pedina.getDirezione();
                    int colonnaAvversaria = partenza.getColonna() + differenza.getColonna() / 2;

                    Pedina avversaria = damiera[rigaAvversaria][colonnaAvversaria].getPedina();

                    if (avversaria != null && avversaria.getTipo() != pedina.getTipo()) {
                        result = avversaria;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Prova a effettuare una presa (singola o multipla).
     *
     * @param posizioni lista contente le posizioni nelle quali si dovra' spostare la pedina,
     *                  la prima posizione deve essere la posizione nella quale si trova
     *                  la pedina che deve effettuare la presa.
     *
     * @return viene restituita una lista di pedine mangiate.
     */
    public List<Pedina> tryPresa(final List<Posizione> posizioni) {
        boolean result = true;
        List<Pedina> pedinePrese = new ArrayList<>();
        Pedina pedina = damiera[posizioni.get(0).getRiga()][posizioni.get(0).getColonna()].getPedina();

        for (int i = 0; i < posizioni.size() - 1 && result; i++) {
            Pedina temp = checkPresa(posizioni.get(i), posizioni.get(i + 1), pedina);
            if (temp != null) {
                pedinePrese.add(temp);
            } else {
                pedinePrese.clear();
                result = false;
            }
        }

        if (result) {
            for (int i = 0; i < pedinePrese.size(); i++) {
                damiera[pedinePrese.get(i).getPosizione().getRiga()]
                    [pedinePrese.get(i).getPosizione().getColonna()].setPedina(null);
            }
            setPosizionePedina(pedina, posizioni.get(posizioni.size() - 1));
        }
        return pedinePrese;
    }

    /**
     * Se possibile effettua lo spostamento semplice.
     *
     * @param pedina pedina da spostare.
     * @param nuovaPosizione posizione nella quale spostare la pedina.
     * @return ritorna true se lo spostamento viene effettuato, altrimenti false.
     */
    private boolean spostamentoSemplice(final Pedina pedina, final Posizione nuovaPosizione) {
        boolean result = false;

        Casella nuovaCasella = damiera[nuovaPosizione.getRiga()][nuovaPosizione.getColonna()];

        if (nuovaCasella.getPedina() == null) {
            int distanzaSpostamentoY = (nuovaPosizione.getRiga() - pedina.getPosizione().getRiga())
                * pedina.getDirezione();

            int distanzaSpostamentoX = Math.abs(nuovaPosizione.getColonna() - pedina.getPosizione().getColonna());

            if (distanzaSpostamentoY == 1 && distanzaSpostamentoX == 1) {
                setPosizionePedina(pedina, nuovaPosizione);
                result = true;
            }
        }
        return result;
    }

    /**
     * Imposta la posizione di una pedina.
     *
     * @param pedina pedina di cui si vuole modificare la posizione.
     * @param nuovaPosizione posizione che va impostata alla pedina.
     */
    private void setPosizionePedina(final Pedina pedina, final Posizione nuovaPosizione) {
        if (pedina.getDirezione() == 1 && nuovaPosizione.getRiga() == dim - 1) {
            pedina.setDama(true);
        } else if (pedina.getDirezione() == -1 && nuovaPosizione.getRiga() == 0) {
            pedina.setDama(true);
        }
        damiera[pedina.getPosizione().getRiga()][pedina.getPosizione().getColonna()].setPedina(null);
        damiera[nuovaPosizione.getRiga()][nuovaPosizione.getColonna()].setPedina(pedina);

        pedina.setPosizione(nuovaPosizione);
    }

    /**
     * Override del metodo toString.
     * @return ritorna una stringa contenente lo stato attuale della damiera.
     */
    @Override
    public String toString() {
        StringBuffer stringa = new StringBuffer();

        for (int riga = 0; riga < damiera.length; riga++) {
            for (int colonna = 0; colonna < damiera.length; colonna++) {
                stringa.append(damiera[riga][colonna].toString());
            }
            stringa.append("\n");
        }
        return stringa.toString();
    }
}
