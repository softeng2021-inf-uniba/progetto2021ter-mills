package it.uniba.main.utilities;


import java.util.Objects;

/**
 * <noECB>
 * Classe che rappresenta le coordinate di una matrice.
 * Essa consente anche di calcolare la differenza tra due posizioni.
 * </noECB>
 */
public class Posizione {
  /**
   * Riga della posizione.
   */
  public int riga;

  /**
   * Colonna della posizione.
   */
  public int colonna;

  /**
   * Costruttore della classe Posizione.
   *
   * @param riga    variabile che viene assegnata al valore della riga della posizione.
   * @param colonna variabile che viene assegnata al valore della colonna della posizione.
   */
  public Posizione(int riga, int colonna) {
    this.riga = riga;
    this.colonna = colonna;
  }

  /**
   * Metodo che serve per calcolare la posizione differenza tra due posizioni.
   *
   * @param pos1 prima posizione
   * @param pos2 seconda posizione
   * @return ritorna la posizione risultato della differenza
   */
  public static Posizione differenza(Posizione pos1, Posizione pos2) {
    Posizione result = null;

    if (pos1 != null && pos2 != null) {
      int newX = pos1.riga - pos2.riga;
      int newY = pos1.colonna - pos2.colonna;
      result = new Posizione(newX, newY);
    }

    return result;
  }

  /**
   * Override del metodo equals utilizzato per confrontare due posizioni.
   *
   * @param o oggetto generico passato per il confronto
   * @return ritorna true se le posizioni coincidono, false altrimenti
   */
  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (o instanceof Posizione) {
      if (riga == ((Posizione) o).riga && colonna == ((Posizione) o).colonna) {
        return true;
      }
    }

    return false;
  }


  /**
   * Override del metodo hashCode.
   *
   * @return Restituisce un valore hash per una posizione
   */
  @Override
  public int hashCode() {
    return Objects.hash(riga, colonna);
  }
}
