package it.uniba.gioco;
import it.uniba.utilities.Strings;

/**
 * <<noECB>>
 * Enumerativo che rappresenta gli stati possibili
 * e ne contiene una descrizione costituita da due parti.
 */

public enum Status {
  /**
   * Status utilizzati durante la partita.
   */
  partita_iniziata(Strings.INIZIO_PARTITA), partita_terminata(Strings.FINE_PARTITA);

  /**
   * Stringhe contenenti le due parti della descrizione dello Status.
   */
  private final String msg1;
  private String msg2;

  /**
   * Costruttore dell'enumerativo Status.
   *
   * @param messaggio1 prima parte della descrizione dello Status.
   */
  Status(final String messaggio1) {
    this.msg1 = messaggio1;
    this.msg2 = "";
  }

  /**
   * Imposta la seconda parte della descrizione dello Status.
   *
   * @param messaggio2 seconda parte della descrizione dello Status.
   */
  void setMsg(final String messaggio2) {
    this.msg2 = messaggio2;
  }

  /**
   * Restituisce la descrizione completa dello Status.
   *
   * @return concatenazione delle due parti della descrizione dello Status.
   */
  public String getMsg() {
    return this.msg1 + this.msg2;
  }
}
