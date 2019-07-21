import java.lang.System;

public class Pomidor extends Warzywo
    {
    public Pomidor()
        {
        super();
        nazwa = "Pomidor";
        koszt = 5;
        }

    public long sprzedaż()
        {
        long obliczenia = System.currentTimeMillis() - narodziny;
        if(obliczenia <= 10000)
            {
            return 0;
            }
        else if(obliczenia <= 15000)
            {
            return 2 * (obliczenia/1000) - 20;
            }
        else if(obliczenia < 20000)
            {
            return (-2) * (obliczenia/1000) + 40;
            }
        else
            {
            return 0;
            }
        }
    }
