package it.uniba.main.parser;

/**
 * <<noECB>>
 * Enumerativo che contiene tutti i comandi disponibili. Esso funge anche da parser dei comandi.
 */
public enum Comando
{
    help(new String[]{"-h","--help","help"}),
    gioca(new String[]{"gioca","play"}),
    abbandona(new String[]{"abbandona","quit"}),
    damiera(new String[]{"damiera"}),
    numeri(new String[]{"numeri"}),
    esci(new String[]{"esci","exit"}),
    tempo(new String[]{"tempo","time"}),
    spostamentoSemplice(new String[]{"(\\d+)-(\\d+)"}),
    presa(new String[]{"((\\d+)x)+(\\d+)"}),
    prese(new String[]{"prese"}),
    mosse(new String[]{"mosse"});

    private String inputStr;
    private String[] aliasList;
    Comando(String[] aliasList)
    {
        this.aliasList = aliasList;
    }

    public static Comando getComando(String str)
    {
        Comando comandoTrovato = null;

        Comando[] listaComandi = Comando.values();

        for (int i = 0; i<listaComandi.length && comandoTrovato == null; ++i)
        {
            Comando cmd = listaComandi[i];
            for (int j = 0; j<cmd.aliasList.length && comandoTrovato == null; ++j)
            {
                if(str.toLowerCase().matches("^" + cmd.aliasList[j] + "$"))
                {
                    comandoTrovato = cmd;
                }
            }
        }

        if (comandoTrovato != null)
        {
            comandoTrovato.inputStr = str;
        }

        return comandoTrovato;
    }

    public String getInputStr()
    {
        return inputStr;
    }
}
