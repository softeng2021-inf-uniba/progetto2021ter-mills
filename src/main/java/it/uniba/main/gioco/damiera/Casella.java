package it.uniba.main.gioco.damiera;

import it.uniba.main.utilities.Strings;

/**
 * <<Entity></Entity>>
 * Classe che rappresenta la casella. Essa si occupa della gestione della pedina contenuta
 * nella determinata casella.
 * Inoltre al suo interno è contenuto l'enumerativo che stabilisce il colore
 * della casella.
 */

public class Casella {

  /**
     * Attributo di tipo Pedina chiamato pedina,
     * utilizzato per salvare la reference della pedina nella casella.
     */
  private Pedina pedina;

  /**
     * Attributo di tipo TipoCasella chiamato tipo,
     * rappresentante la tipologia della casella (bianca o nera).
     */
  private TipoCasella tipo;

  /**
     * Costruttore della classe Casella.

     * @param tipologia determina il tipo della casella.
     */
  public Casella(final TipoCasella tipologia) {
    this.pedina = null;
    this.tipo = tipologia;
  }

  /**
     * Metodo setter del tipo della casella.

     * @param tipologia stabilisce il tipo della casella (bianca o nera).
     */
  public void setTipoCasella(final TipoCasella tipologia) {
    this.tipo = tipologia;
  }

  /**
     * Metodo getter della pedina presente nella casella.

     * @return ritorna la reference della pedina salvata nella casella.
     */
  public Pedina getPedina() {
    return pedina;
  }

  /**
     * Metodo setter della pedina.
     * Salva la reference della pedina passata

     * @param nuovaPedina è la variabile di tipo pedina da memorizzare
     */
  public void setPedina(final Pedina nuovaPedina) {
    this.pedina = nuovaPedina;
  }

  /**
     * Metodo toString della classe casella.

     * @return una stringa rappresentante il colore della casella,
     *     e se esistente la pedina associata.
     */
  @Override
    public String toString() {
    String result = "";

    if (tipo == TipoCasella.bianca) {
      result += Strings.RGB_CREMA_BG;
    } else {
      result += Strings.RGB_INDACO_BG;
    }
    result += " ";
    if (pedina != null) {
      result += pedina.toString();
    } else {
      result += Strings.CASELLA_VUOTA;
    }
    result += " ";
    result += Strings.ANSI_RESET;

    return result;
  }

}
