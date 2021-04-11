package it.uniba.main;

import it.uniba.main.gioco.*;
import it.uniba.main.parser.*;
import it.uniba.main.utilities.*;

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

        if (args.length > 0 && Comando.getComando(args[0]) == Comando.help)
        {
            System.out.println(Strings.HELP_MSG);
        }
        else
        {
            System.out.println(Strings.SUGGERIMENTO_HELP);
        }

        GameModel gameModel = new GameModel(8);

        GameController gameController = new GameController(gameModel);

        System.exit(0);
    }

}
