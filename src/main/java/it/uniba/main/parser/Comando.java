package it.uniba.main.parser;

public enum Comando
{
    Help(new String[]{"-h","--help","help"});


    private String[] aliasList;
    Comando(String[] aliasList)
    {
        this.aliasList = aliasList;
    }


    public static Comando getComando(String str)
    {
        Comando comandoTrovato = null;

        Comando[]listaComandi = Comando.values();

        for (int i = 0; i<listaComandi.length && comandoTrovato == null; ++i)
        {
            Comando cmd = listaComandi[i];
            for (int j = 0; j<cmd.aliasList.length && comandoTrovato == null; ++j)
            {
                if(str.toLowerCase().equals(cmd.aliasList[j]))
                {
                    comandoTrovato = cmd;
                }
            }
        }
        return comandoTrovato;
    }
}
