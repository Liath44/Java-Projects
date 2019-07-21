import java.lang.System;

public abstract class Warzywo
    {
    protected String nazwa;
    protected long koszt;
    protected long narodziny;

    public Warzywo()
        {
        narodziny = System.currentTimeMillis();
        }

    public abstract long sprzedaż();
    }
