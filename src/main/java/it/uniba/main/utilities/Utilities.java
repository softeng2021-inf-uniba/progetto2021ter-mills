package it.uniba.main.utilities;

import java.util.Scanner;

/**
 * <noECB>
 * CLasse di Utility statica che esegue operazioni eterogenee e frequentemente utilizzate.
 */

public final class Utilities {
  static final int NUM = 10;
  static final int DIVISION_PER_SECOND = 1000;
  static final int DIVISION_PER_MINUTE = 60000;
  static final int SECOND = 60;

  private Utilities() {

  }

  /**
   * Metodo che prende una stringa digitata da tastiera secondo
   * la "UTF-8".
   *
   * @return una stringa digitata da tastiera in UTF-8.
   */
  public static String getStringaDaTastiera() {
    Scanner input = new Scanner(System.in, "UTF-8");
    String inputString = input.nextLine();
    return inputString;
  }

  /**
   * Metodo che toglie eventuali spazi da una stringa
   * digitata da tastiera.
   *
   * @param stringa = stringa restituita dal metodo
   *                getStringaDaTastiera
   * @return viene restituita la stringa senza gli spazi
   */

  public static String pulisciStringa(final String stringa) {
    return stringa.trim();
  }

  /**
   * Metodo utilizzato per lo spostamento della pedina.
   *
   * @param numCasella variabile intera associata al numero di una certa casella della damiera
   *                   utilizzata come rappresentazione astratta all'interno del gioco.
   * @param dimDamiera = dimensione della damiera.
   * @return una nuova posizione.
   */

  public static Posizione convertiPosizione(final int numCasella, final int dimDamiera) {
    int riga = (int) Math.floor((numCasella - 1) / (dimDamiera / 2.0));
    int colonna = (numCasella - (riga * dimDamiera / 2));
    colonna *= 2;
    if (riga % 2 == 0) {
      colonna -= 2;
    } else {
      colonna -= 1;
    }

    return new Posizione(riga, colonna);
  }

  /**
   * Metodo che stampa il tempo nel formato ("mm:ss").
   *
   * @param millisecondi = tempo restituito da currentTimeMillis()
   * @return stringa tempo nel formato ("mm:ss").
   */

  public static String getStringaTempo(final long millisecondi) {
    int secondi = (int) ((millisecondi / DIVISION_PER_SECOND) % SECOND);
    int minuti = (int) (millisecondi / DIVISION_PER_MINUTE);

    String tempo = "";
    if (minuti < NUM) {
      tempo += "0";
    }
    tempo += minuti + ":";
    if (secondi < NUM) {
      tempo += "0";
    }
    tempo += secondi;
    return tempo;
  }
}
