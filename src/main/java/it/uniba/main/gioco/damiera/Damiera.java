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
    private final int DIM;
    private Casella[][] damiera;

    private List<Pedina> listaPedineBianche;
    private List<Pedina> listaPedineNere;


    public Damiera(int dim)
    {
        this.DIM = dim;
        init();
    }

    public void init()
    {
        setupCaselle();
        setupPedine();
    }


    private void setupCaselle()
    {
        damiera = new Casella[DIM][DIM];

        for (int i = 0; i < DIM; i++)
        {
            for (int j = 0; j < DIM; j++)
            {
                damiera[i][j] = new Casella(Casella.TipoCasella.bianca);
                if (((i * (DIM + 1) + j) % 2) == 0)
                {
                    damiera[i][j].setTipoCasella(Casella.TipoCasella.nera);
                }
            }
        }
    }

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

    public boolean isPosizioneValida(Posizione posizione)
    {
        return posizione.riga >= 0 && posizione.riga < DIM && posizione.colonna >= 0 && posizione.colonna < DIM;
    }

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


    public Pedina getPedina(Posizione pos)
    {
        Pedina pedina = null;
        if (isPosizioneValida(pos))
        {
            pedina = damiera[pos.riga][pos.colonna].getPedina();
        }
        return pedina;
    }


    public boolean trySpostamentoSemplice(Pedina pedina, Posizione nuovaPosizione)
    {
        boolean result = false;

        if (isPosizioneValida(nuovaPosizione))
        {
            result = spostamentoSemplice(pedina, nuovaPosizione);
        }

        return result;
    }


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

    @Override
    public String toString()
    {
        String stringa = "";

        for (int riga = 0; riga < damiera.length; riga++)
        {
            for (int colonna = 0; colonna < damiera.length; colonna++)
            {
                stringa += damiera[riga][colonna].toString();
            }
            stringa += "\n";
        }
        return stringa;
    }
}
