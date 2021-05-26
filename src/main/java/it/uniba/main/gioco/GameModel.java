package it.uniba.main.gioco;

import it.uniba.main.gioco.damiera.Damiera;
import it.uniba.main.gioco.damiera.Pedina;
import it.uniba.main.utilities.Cronometro;
import it.uniba.main.utilities.Posizione;
import it.uniba.main.utilities.Strings;
import it.uniba.main.utilities.Utilities;
import it.uniba.main.utilities.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 * <<Control>>
 * Gestisce la logica del gioco e comunica al controller
 * il cambio di stato del gioco per mezzo di observer
 */
public class GameModel {
    private Damiera damiera;
    private boolean isPlaying;
    private boolean isTurnoBianco;
    private Cronometro cronometroBianco;
    private Cronometro cronometroNero;
    private List<String> storicoMosse;


    private int dimDamiera;
    private int punteggioBianco;
    private int punteggioNero;

    private Subject<Status> onStatusChanged;
    private Subject<Messaggio> onMessagesCalled;


    public GameModel(final int dimensioneDamiera) {
        onStatusChanged = new Subject<>();
        onMessagesCalled = new Subject<>();
        this.dimDamiera = dimensioneDamiera;
    }

    /**
     *
     */
    public void startGame() {
        this.punteggioBianco = 0;
        this.punteggioNero = 0;
        this.storicoMosse = new ArrayList<>();
        damiera = new Damiera(dimDamiera);
        if (cronometroBianco != null) {
            cronometroBianco.stop();
            cronometroNero.stop();
        } else {
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

    private Pedina tryGetPedina(final Posizione posPedina) {
        Pedina pedina = null;
        try {
            if (damiera.isPosizioneValida(posPedina)) {
                pedina = damiera.getPedina(posPedina);
                if (pedina == null) {
                    notificaMessaggio(Messaggio.casella_vuota);
                } else if (!damiera.isPedinaValida(pedina, isTurnoBianco)) {
                    pedina = null;
                    notificaMessaggio(Messaggio.pedina_avversaria);
                }
            } else {
                notificaMessaggio(Messaggio.posizione_out_of_range);
            }
        } catch (Exception e) {
            Messaggio.errore_generico.setMsg(e.toString());
            notificaMessaggio(Messaggio.errore_generico);
        }
        return pedina;
    }

    /**
     *
     * @param caselle
     */
    public void eseguiPresa(final String[] caselle) {
        List<Posizione> posizioni = new ArrayList<>();

        for (int i = 0; i < caselle.length; i++) {
            posizioni.add(Utilities.convertiPosizione(Integer.parseInt(caselle[i]), dimDamiera));
        }

        Pedina pedinaPartenza = tryGetPedina(posizioni.get(0));

        boolean isDama = pedinaPartenza.isDama();

        if (pedinaPartenza != null) {
            List<Pedina> pedinePrese = damiera.tryPresa(posizioni);

            if (pedinePrese.size() > 0) {
                StringBuffer tempStorico = new StringBuffer();
                tempStorico.append("");
                if (isTurnoBianco) {
                    punteggioBianco += pedinePrese.size();
                    tempStorico.append("B: ");
                } else {
                    punteggioNero += pedinePrese.size();
                    tempStorico.append("N: ");
                }
                for (int i = 0; i < caselle.length - 1; i++) {
                    tempStorico.append(caselle[i] + "x");
                }
                tempStorico.append(caselle[caselle.length - 1]);
                this.storicoMosse.add(tempStorico.toString());

                notificaMessaggio(Messaggio.presa_eseguita);

                if (!isDama && pedinaPartenza.isDama()) {
                    notificaMessaggio(Messaggio.damatura_effettuata);
                }
                cambioTurno();
            } else {
                notificaMessaggio(Messaggio.presa_errata);
            }
        }
    }

    /**
     *
     * @param partenza
     * @param arrivo
     */
    public void eseguiSpostamentoSemplice(final int partenza, final int arrivo) {
        Posizione posPartenza = Utilities.convertiPosizione(partenza, dimDamiera);
        Posizione posArrivo = Utilities.convertiPosizione(arrivo, dimDamiera);

        if (damiera.isPosizioneValida(posArrivo)) {
            Pedina pedina = tryGetPedina(posPartenza);
            boolean isDama = pedina.isDama();
            if (pedina != null) {
                boolean isSpostata = damiera.trySpostamentoSemplice(pedina, posArrivo);
                if (isSpostata) {
                    if (isTurnoBianco) {
                        this.storicoMosse.add(("B: ") + partenza + "-" + arrivo);
                    } else {
                        this.storicoMosse.add(("N: ") + partenza + "-" + arrivo);
                    }
                    notificaMessaggio(Messaggio.spostamento_effettuato);

                    if (!isDama && pedina.isDama()) {
                        notificaMessaggio(Messaggio.damatura_effettuata);
                    }
                    cambioTurno();
                } else {
                    notificaMessaggio(Messaggio.spostamento_errato);
                }
            }
        } else {
            notificaMessaggio(Messaggio.posizione_out_of_range);
        }
    }

    private void cambioTurno() {
        isTurnoBianco = !isTurnoBianco;
        if (isTurnoBianco) {
            Messaggio.cambio_giocatore.setMsg(Strings.GIOCATORE_BIANCO);
        } else {
            Messaggio.cambio_giocatore.setMsg(Strings.GIOCATORE_NERO);
        }
        if (isTurnoBianco) {
            cronometroNero.pausa();
            cronometroBianco.riprendi();
        } else {
            cronometroBianco.pausa();
            cronometroNero.riprendi();
        }
        notificaMessaggio(Messaggio.cambio_giocatore);
    }

    /**
     *
     */
    public void abbandonaPartita() {
        if (isTurnoBianco) {
            Status.partita_terminata.setMsg(Strings.GIOCATORE_NERO);
        } else {
            Status.partita_terminata.setMsg(Strings.GIOCATORE_BIANCO);
        }
        setStatus(Status.partita_terminata);
        isPlaying = false;
    }

    /**
     *
     * @param status
     */
    public void setStatus(final Status status) {
        onStatusChanged.notifyObservers(status);
    }

    /**
     *
     * @param message
     */
    private void notificaMessaggio(final Messaggio message) {
        onMessagesCalled.notifyObservers(message);
    }

    /**
     *
     * @return
     */
    public boolean getIsPlaying() {
        return isPlaying;
    }

    /**
     *
     * @return
     */
    public Subject<Status> getOnStatusChanged() {
        return onStatusChanged;
    }

    /**
     *
     * @return
     */
    public Subject<Messaggio> getOnMessagesCalled() {
        return onMessagesCalled;
    }

    /**
     *
     * @return
     */
    public String getDamiera() {
        return damiera.toString();
    }

    /**
     *
     * @return
     */
    public int getDimDamiera() {
        return dimDamiera;
    }

    /**
     *
     * @return
     */
    public Cronometro getCronometroBianco() {
        return cronometroBianco;
    }

    /**
     *
     * @return
     */
    public Cronometro getCronometroNero() {
        return cronometroNero;
    }

    /**
     *
     * @return
     */
    public int getPunteggioBianco() {
        return punteggioBianco;
    }

    /**
     *
     * @return
     */
    public int getPunteggioNero() {
        return punteggioNero;
    }

    /**
     *
     * @return
     */
    public List<String> getStoricoMosse() {
        return storicoMosse;
    }
}
