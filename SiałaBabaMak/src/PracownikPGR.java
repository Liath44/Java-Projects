import java.lang.System;

public class PracownikPGR extends Rolnik
    {
    public PracownikPGR(int k)
        {
        super(k);
        }

    private void zbieraj(Warzywo[] ogrodo)
        {
        for(int i = 0; i < ogrodo.length; i++)
            {
            ogrodo[i].koszt = ogrodo[i].sprzedaż();
            zbiory.add(ogrodo[i]);
            System.out.println("Zebrano: " + ogrodo[i].nazwa + " | Wartość: " + ogrodo[i].koszt + " PLN");
            }
        }

    public void symuluj(Warzywo[] ogrodo, int time)
        {
        Warzywo[] ogrodoo = kopiuj_ogrod(ogrodo);
        long czas = time * 1000;
        long start = System.currentTimeMillis();
        try
            {
            Thread.sleep(10000);
            }
        catch(InterruptedException e)
            {
            System.out.println("ERROR!");
            }
        if(System.currentTimeMillis() - start < czas)
            {
            zbieraj(ogrodoo);
            }
        while(System.currentTimeMillis() - start < czas)
            {
            sadz(ogrodoo);
            try
                {
                Thread.sleep(10000);
                }
            catch(InterruptedException e)
                {
                System.out.println("ERROR!");
                }
            if(System.currentTimeMillis() - start < czas)
                {
                zbieraj(ogrodoo);
                }
            }
        raport();
        }
    }
