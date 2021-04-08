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
}
