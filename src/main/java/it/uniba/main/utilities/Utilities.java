package it.uniba.main.utilities;

import java.util.Scanner;

public class Utilities {

    public static String getStringaDaTastiera() {
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        return inputString;
    }

    public static String pulisciStringa(String stringa) {
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
