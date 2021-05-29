package it.uniba.main.gioco.damiera;

import it.uniba.main.utilities.Posizione;
import it.uniba.main.utilities.Strings;

/**
 * <Entity>
 * Classe che rappresenta la pedina.
 */

public class Pedina {
  /**
   * Attributo di tipo TipoPedina che rappresenta il colore della pedina (bianco o nero).
   */
  private TipoPedina tipo;

  /**
   * Attributo di tipo Posizione che rappresenta la posizione della pedina nella dama.
   */
  private Posizione posizione;

  /**
   * booleano che rappresenta se una pedina è Dama o meno.
   */
  private boolean isDama;


  /**
   * Costruttore della classe Pedina.
   *
   * @param tipoPedina determina il tipo della pedina.
   * @param pos determina la posizione della pedina.
   */
  public Pedina(final TipoPedina tipoPedina, final Posizione pos) {
    this.tipo = tipoPedina;
    this.posizione = pos;
    this.isDama = false;
  }

  /**
   * Metodo getter del tipo della pedina.
   *
   * @return il tipo della pedina.
   */

  public TipoPedina getTipo() {
    return tipo;
  }

  /**
   * Metodo getter della direzione della pedina.
   *
   * @return la direzione della pedina, se è bianca si muove verso l'alto della matrice (-1),
   *     altrimenti verso il basso (1).
   */
  public int getDirezione() {
    int valoreRitorno = 0;
    if (tipo == TipoPedina.bianca) {
      valoreRitorno = -1;
    } else {
      valoreRitorno = 1;
    }
    return valoreRitorno;
  }

  /**
   * Metodo toString della classe Pedina.
   *
   * @return restituisce la stringa che rappresenta la pedina nello stato corrente.
   */

  @Override
  public String toString() {
    String result = "";
    if (isDama) {
      if (tipo == TipoPedina.bianca) {
        result += Strings.PEDINA_REGINA_BIANCA;
      } else {
        result += Strings.PEDINA_REGINA_NERA;
      }
    } else {
      if (tipo == TipoPedina.bianca) {
        result += Strings.PEDINA_BIANCA;
      } else {
        result += Strings.PEDINA_NERA;
      }
    }
    return result;
  }

  /**
   * Metodo getter dell'attributo posizione.
   * @return restituisce valore della posizione.
   */
  public Posizione getPosizione() {
    return posizione;
  }

  /**
   * Metodo getter dell'attributo isDama.
   * @return restituisce true se la pedina e' una dama.
   */
  public boolean isDama() {
    return isDama;
  }

  /**
   * Metodo setter dell'attributo posizione.
   * @param pos è il valore della posizione da impostare.
   */
  public void setPosizione(final Posizione pos) {
    this.posizione = pos;
  }

  /**
   * Metodo setter dell'attributo dama.
   * @param dama è il valore della dama da impostare.
   */
  public void setDama(final boolean dama) {
    isDama = dama;
  }
}
