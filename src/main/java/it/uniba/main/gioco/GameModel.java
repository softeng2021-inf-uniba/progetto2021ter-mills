package it.uniba.main.gioco;

import it.uniba.main.gioco.damiera.Casella;
import it.uniba.main.gioco.damiera.Damiera;
import it.uniba.main.gioco.damiera.Pedina;
import it.uniba.main.utilities.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <<Control>>
 * Gestisce la logica del gioco e comunica al controller
 * il cambio di stato del gioco per mezzo di observer
 */
public class GameModel
{
    private Damiera damiera;
    private boolean isPlaying;
    private boolean isTurnoBianco;
    private Cronometro cronometroBianco;
    private Cronometro cronometroNero;
    private List<String> storicoMosse;


    private int dimDamiera;
    private int punteggioBianco;
    private int punteggioNero;

    private Status status;
    private Subject<Status> onStatusChanged;
    private Subject<Messaggio> onMessagesCalled;


    public GameModel(int dimDamiera)
    {
        onStatusChanged = new Subject<>();
        onMessagesCalled = new Subject<>();
        this.dimDamiera = dimDamiera;
        //TODO
    }


    public void startGame()
    {
        this.punteggioBianco = 0;
        this.punteggioNero = 0;
        this.storicoMosse = new ArrayList<>();
        damiera = new Damiera(dimDamiera);
        if (cronometroBianco != null)
        {
            cronometroBianco.stop();
            cronometroNero.stop();
        }
        else
        {
            cronometroBianco = new Cronometro();
            cronometroNero = new Cronometro();
        }
        isTurnoBianco = true;
        isPlaying = true;
        cronometroBianco.start();
        setStatus(Status.partita_iniziata);

        Messaggio.cambio_giocatore.setMsg(Strings.GIOCATORE_BIANCO);
        notificaMessaggio(Messaggio.cambio_giocatore);
    }

    private Pedina tryGetPedina(Posizione posPedina)
    {
        Pedina pedina = null;
        try
        {
            if (damiera.isPosizioneValida(posPedina))
            {
                pedina = damiera.getPedina(posPedina);
                if (pedina == null)
                {
                    notificaMessaggio(Messaggio.casella_vuota);
                }
                else if (!damiera.isPedinaValida(pedina, isTurnoBianco))
                {
                    pedina = null;
                    notificaMessaggio(Messaggio.pedina_avversaria);
                }
            }
            else
            {
                notificaMessaggio(Messaggio.posizione_out_of_range);
            }
        } catch (Exception e)
        {
            Messaggio.errore_generico.setMsg(e.toString());
            notificaMessaggio(Messaggio.errore_generico);
        }
        return pedina;
    }


    public void eseguiPresa(String caselle[])
    {
        List<Posizione> posizioni = new ArrayList<>();

        for (int i = 0; i < caselle.length; i++)
        {
            posizioni.add(Utilities.convertiPosizione(Integer.parseInt(caselle[i]), dimDamiera));
        }

        Pedina partenza = tryGetPedina(posizioni.get(0));

        if (partenza != null)
        {
            List<Pedina> pedinePrese = damiera.tryPresa(posizioni);

            if (pedinePrese.size() > 0)
            {
                String tempStorico = "";
                if (isTurnoBianco)
                {
                    punteggioBianco += pedinePrese.size();
                    tempStorico += "B: ";
                }
                else
                {
                    punteggioNero += pedinePrese.size();
                    tempStorico += "N: ";
                }
                for(int i = 0; i < caselle.length-1; i++)
                {
                    tempStorico += caselle[i] + "x";
                }
                tempStorico += caselle[caselle.length-1];
                this.storicoMosse.add(tempStorico);
                notificaMessaggio(Messaggio.eseguita);
                cambioTurno();
            }
            else
            {
                notificaMessaggio(Messaggio.presa_errata);
            }
        }
        else
        {
            notificaMessaggio(Messaggio.casella_vuota);
        }

    }

    public void eseguiSpostamentoSemplice(int partenza, int arrivo)
    {
        Posizione posPartenza = Utilities.convertiPosizione(partenza, dimDamiera);
        Posizione posArrivo = Utilities.convertiPosizione(arrivo, dimDamiera);

        if (damiera.isPosizioneValida(posArrivo))
        {
            Pedina pedina = tryGetPedina(posPartenza);
            if (pedina != null)
            {
                boolean isSpostata = damiera.trySpostamentoSemplice(pedina, posArrivo);
                if (isSpostata)
                {
                    this.storicoMosse.add((isTurnoBianco ? "B: " : "N: ") + partenza + "-" + arrivo);

                    notificaMessaggio(Messaggio.eseguita);
                    cambioTurno();
                }
                else
                {
                    notificaMessaggio(Messaggio.spostamento_errato);
                }
            }
        }
        else
        {
            notificaMessaggio(Messaggio.posizione_out_of_range);
        }
    }

    private void cambioTurno()
    {
        isTurnoBianco = !isTurnoBianco;
        Messaggio.cambio_giocatore.setMsg(isTurnoBianco ? Strings.GIOCATORE_BIANCO : Strings.GIOCATORE_NERO);

        if (isTurnoBianco)
        {
            cronometroNero.pausa();
            cronometroBianco.riprendi();
        }
        else
        {
            cronometroBianco.pausa();
            cronometroNero.riprendi();
        }

        notificaMessaggio(Messaggio.cambio_giocatore);
    }

    public void abbandonaPartita()
    {
        Status.partita_terminata.setMsg(isTurnoBianco ? Strings.GIOCATORE_NERO : Strings.GIOCATORE_BIANCO);
        setStatus(Status.partita_terminata);
        isPlaying = false;
    }

    public void setStatus(Status status)
    {
        this.status = status;
        onStatusChanged.notifyObservers(status);
    }

    private void notificaMessaggio(Messaggio message)
    {
        onMessagesCalled.notifyObservers(message);
    }


    public boolean getIsPlaying()
    {
        return isPlaying;
    }

    public Subject<Status> getOnStatusChanged()
    {
        return onStatusChanged;
    }

    public Subject<Messaggio> getOnMessagesCalled()
    {
        return onMessagesCalled;
    }

    public String getDamiera()
    {
        return damiera.toString();
    }

    public int getDimDamiera()
    {
        return dimDamiera;
    }

    public Cronometro getCronometroBianco()
    {
        return cronometroBianco;
    }

    public Cronometro getCronometroNero()
    {
        return cronometroNero;
    }

    public int getPunteggioBianco()
    {
        return punteggioBianco;
    }

    public int getPunteggioNero()
    {
        return punteggioNero;
    }

    public List<String> getStoricoMosse()
    {
        return storicoMosse;
    }
}
