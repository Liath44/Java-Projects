import java.util.Random;
import java.lang.System;

public class Marchew extends Warzywo
    {
    Random r = new Random();

    public Marchew()
        {
        super();
        nazwa = "Marchew";
        koszt = 4;
        }

    public long sprzedaż()
        {
        long akt_czas = System.currentTimeMillis();
        if(akt_czas - narodziny < 8000)
            {
            return 0;
            }
        else if(akt_czas - narodziny <= 11000)
            {
            /*int a = r.nextInt(2);
            if(a == 0)
                {
                return 3;
                }
            else
                {
                return 7;
                }*/
            return 7;
            }
        else if(akt_czas - narodziny <= 15000)
            {
            /*int a = r.nextInt(2);
            if(a == 0)
                {
                return 0;
                }
            else
                {
                return 2;
                }*/
            return 3;
            }
        else
            {
            return 0;
            }
        }
    }
