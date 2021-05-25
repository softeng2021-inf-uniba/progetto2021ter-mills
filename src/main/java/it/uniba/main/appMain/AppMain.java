package it.uniba.main.appMain;

import it.uniba.main.gioco.GameController;
import it.uniba.main.gioco.GameModel;
import it.uniba.main.parser.Comando;
import it.uniba.main.utilities.Strings;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * <<noECB>>
 * Classe runnabile che fa partire il programma. Permette di passare degli argomenti come parametro.
 */

public final class AppMain {

    /**
     * Costruttore della classe AppMain.
     */
    private AppMain() {

    }

    /**
     * * Main entry dell'applicazione con endcoding di tipo "UTF-8".
     *
     * @param args argomenti passati all'avvio dell'applicazione da console.
     */
    public static void main(final String[] args) {
         final int dimDamiera = 8;
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(Strings.BENVENUTO);

        if (args.length > 0 && Comando.getComando(args[0]) == Comando.help) {
            System.out.println(Strings.HELP_MSG);
        } else {
            System.out.println(Strings.SUGGERIMENTO_HELP);
        }

        GameModel gameModel = new GameModel(dimDamiera);

        new GameController(gameModel);

        System.exit(0);
    }

}
