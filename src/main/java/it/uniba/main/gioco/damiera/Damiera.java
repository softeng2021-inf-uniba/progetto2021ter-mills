package it.uniba.main.gioco.damiera;

import it.uniba.main.utilities.Posizione;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

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
                Pedina pedina = new Pedina(Pedina.TipoPedina.nera, new Posizione(i, j));
                damiera[i][j].setPedina(pedina);
                listaPedineBianche.add(pedina);
            }
        }

        //Posizionamento pedine bianche
        for (int i = DIM - 3; i < DIM; i++)
        {
            for (int j = i % 2; j < DIM; j += 2)
            {
                Pedina pedina = new Pedina(Pedina.TipoPedina.bianca, new Posizione(i, j));
                damiera[i][j].setPedina(pedina);
                listaPedineNere.add(pedina);
            }
        }
    }

    public boolean isPosizioneValida(Posizione posizione)
    {
        return posizione.x >= 0 && posizione.x < DIM && posizione.y >= 0 && posizione.y < DIM;
    }

    public boolean isPedinaValida(Pedina pedina, boolean isTurnoBianco)
    {
        boolean result = false;

        if (pedina != null)
        {
            if ((isTurnoBianco && pedina.getTipo() == Pedina.TipoPedina.bianca) || (!isTurnoBianco && pedina.getTipo() == Pedina.TipoPedina.nera))
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
            pedina = damiera[pos.x][pos.y].getPedina();
        }
        return pedina;
    }

    public Casella[][] getDamiera()
    {
        return damiera;
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
            Posizione differenza = Posizione.differenza(arrivo, partenza);

            if (differenza.x * pedina.getDirezione() == 2 && differenza.y * pedina.getDirezione() == 2)
            {
                int xAvversaria = arrivo.x + differenza.x / 2;
                int yAvversaria = arrivo.y + pedina.getDirezione();

                Pedina avversaria = damiera[xAvversaria][yAvversaria].getPedina();


                if (avversaria != null && avversaria.getTipo() != pedina.getTipo())
                {
                    result = avversaria;
                }
            }

        }


        return result;
    }

    public boolean tryPresa(List<Posizione> posizioni, boolean turno)
    {
        boolean result = true;
        List<Pedina> pedinaPrese = new ArrayList<>();



        for (int i = 0; i < posizioni.size() - 1 && result; i++)
        {
            //Pedina temp = checkPresa();

        }


        return result;
    }


    private boolean spostamentoSemplice(Pedina pedina, Posizione nuovaPosizione)
    {
        boolean result = false;

        Casella nuovaCasella = damiera[nuovaPosizione.x][nuovaPosizione.y];

        if (nuovaCasella.getPedina() == null)
        {
            int distanzaSpostamentoY = (nuovaPosizione.x - pedina.posizione.x) * pedina.getDirezione();

            int distanzaSpostamentoX = Math.abs(nuovaPosizione.y - pedina.posizione.y);

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
        damiera[pedina.posizione.x][pedina.posizione.y].setPedina(null);
        damiera[nuovaPosizione.x][nuovaPosizione.y].setPedina(pedina);

        pedina.posizione = nuovaPosizione;
    }
}
