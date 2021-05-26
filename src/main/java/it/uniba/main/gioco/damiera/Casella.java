package it.uniba.main.gioco.damiera;

import it.uniba.main.utilities.Strings;

/**
 * <Entity>
 * Classe che rappresenta la casella. Inoltre, si occupa della gestione della pedina contenuta in essa contentua.
 */

public class Casella {

  /**
     * Pedina presente nella casella
     */
  private Pedina pedina;

  /**
     * Attributo di tipo TipoCasella che rappresentante la tipologia della casella (bianca o nera).
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
     * @param nuovaPedina Pedina da impostare nella varibile pedina
     */
  public void setPedina(final Pedina nuovaPedina) {
    this.pedina = nuovaPedina;
  }

  /**
     * Override del metodo toString.
     * @return stringa che rappresenta la casella nella stato corrente
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
