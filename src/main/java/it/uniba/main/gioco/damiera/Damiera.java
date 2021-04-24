package it.uniba.main.gioco.damiera;

import it.uniba.main.utilities.Posizione;

import java.util.ArrayList;
import java.util.List;

public class Damiera
{
    private final int DIM;
    private Casella[][] damiera;

    private List<Pedina> listaPedineBianche;
    private List<Pedina> listaPedineNere;


    public Damiera (int dim){
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
                if (((i * (DIM + 1) + j) % 2) != 0)
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

        //Posizionamento pedine bianche
        for (int i = 0; i < 3; i++)
        {
            for (int j = (i + 1) % 2; j < DIM; j += 2)
            {
                Pedina pedina = new Pedina(Pedina.TipoPedina.bianca, new Posizione(i, j));
                damiera[i][j].setPedina(pedina);
                listaPedineBianche.add(pedina);
            }
        }

        //Posizionamento pedine nere
        for (int i = DIM - 3; i < DIM; i++)
        {
            for (int j = (i + 1) % 2; j < DIM; j += 2)
            {
                Pedina pedina = new Pedina(Pedina.TipoPedina.nera, new Posizione(i, j));
                damiera[i][j].setPedina(pedina);
                listaPedineNere.add(pedina);
            }
        }
    }

    private boolean isPosizioneValida(Posizione posizione)
    {
        return posizione.x >= 0 && posizione.x < DIM && posizione.y >= 0 && posizione.y < DIM;
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

}
