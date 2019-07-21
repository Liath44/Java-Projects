import java.lang.System;

public class Ziemniak extends Warzywo
    {
    public Ziemniak()
        {
        super();
        nazwa = "Ziemnia";
        koszt = 2;
        }

    public long sprzedaż()
        {
        long akt_czas = System.currentTimeMillis();
        if(akt_czas - narodziny < 10000)
            {
            return 0;
            }
        else
            {
            return 5;
            }
        }
    }
