package it.uniba.main.utilities;

import java.util.Scanner;


/**
 * <<noECB>>
 * CLasse di Utility statica che esegue operazioni eterogenee e frequentemente utilizzate
 */
public class Utilities {

    public static String getStringaDaTastiera() {
        Scanner input = new Scanner(System.in, "UTF-8");
        String inputString = input.nextLine();
        return inputString;
    }

    public static Posizione convertiPosizione(int numCasella, int dimDamiera)
    {
        int riga = (int) Math.floor((numCasella-1) / (dimDamiera / 2.0));
        int colonna = (numCasella - (riga * dimDamiera / 2));
        colonna *= 2;
        colonna -= riga % 2 == 0 ? 2 : 1;

        return new Posizione(riga, colonna);
    }

    public static String pulisciStringa(String stringa)
    {
        return stringa.trim();
    }

    public static String getStringaTempo(long millisecondi)
    {
        int secondi = (int)((millisecondi / 1000)%60);
        int minuti = (int)(millisecondi/60000);
        String tempo = "";
        if(minuti < 10)
        {
            tempo += "0";
        }
        tempo += minuti + ":";
        if(secondi < 10)
        {
            tempo += "0";
        }
        tempo += secondi;
        return tempo;
    }
}
