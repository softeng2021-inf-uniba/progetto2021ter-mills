package it.uniba.main;

import it.uniba.main.gioco.GameController;
import it.uniba.main.parser.Comando;
import it.uniba.main.utilities.Strings;
import it.uniba.main.utilities.Utilities;

/**
 * The main class for the project. It must be customized to meet the project
 * assignment specifications.
 *
 * <b>DO NOT RENAME</b>
 */
public final class AppMain
{

    /**
     * Private constructor. Change if needed.
     */
    private AppMain()
    {

    }

    /**
     * * This is the main entry of the application.
     *
     * @param args The command-line arguments.
     */
    public static void main(final String[] args)
    {
        System.out.println(Strings.BENVENUTO);

        if (args.length > 0 && Comando.getComando(args[0]) == Comando.Help)
        {
            System.out.println(Strings.HELP_MSG);
        }
        else
        {
            System.out.println(Strings.SUGGERIMENTO_HELP);
        }

        GameController gameController = new GameController();
    }

}
