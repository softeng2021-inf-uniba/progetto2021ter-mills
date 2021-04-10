package it.uniba.main.gioco;

import it.uniba.main.utilities.Strings;

public enum Status
{
    partita_iniziata(Strings.INIZIO_PARTITA);
    
    private final String msg1;
    private String msg2;

    private Status(String msg1)
    {
        this.msg1 = msg1;
        this.msg2 = "";
    }
    private Status(String msg1, String msg2)
    {
        this.msg1 = msg1;
        this.msg2 = msg2;
    }

    public void setMsg(String msg2)
    {
        this.msg2 = msg2;
    }

    public String getMsg()
    {
        return this.msg1 + this.msg2;
    }

}