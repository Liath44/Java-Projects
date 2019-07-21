import java.lang.System;

public class Gospodarz extends Rolnik
    {
    private long[] zeszyt_cen;

    public Gospodarz(int k)
        {
        super(k);
        zeszyt_cen = new long[k];
        for(int i = 0; i < k; i++)
            {
            zeszyt_cen[i] = 0;
            }
        }

    public void symuluj(Warzywo[] ogrodo, int time)
        {
        Warzywo[] ogrodoo = kopiuj_ogrod(ogrodo);
        long czas = time * 1000;
        long start = System.currentTimeMillis();
        try
            {
            Thread.sleep(1000);
            }
        catch(InterruptedException e)
            {
            System.out.println("ERROR!");
            }
        while(System.currentTimeMillis() - start < czas)
            {
            for(int i = 0; i < ogrodoo.length; ++i)
                {
                if(zeszyt_cen[i] > ogrodoo[i].sprzedaż())//sprzedajemy, marchewki tu trochę się psują w implementacji losowej - do łatwego naprawienia ale uciążliwe
                    {
                    zeszyt_cen[i] = 0;
                    ogrodoo[i].koszt = ogrodoo[i].sprzedaż();
                    zbiory.add(ogrodoo[i]);
                    System.out.println("Zebrano: " + ogrodoo[i].nazwa + " | Wartość: " + ogrodoo[i].koszt + " PLN");
                    sadz_jeden(ogrodoo, i);//moze dodam pozniej inspekcję czy mu się to jeszcze opłaca (dod 1 sek)
                    }
                else
                    {
                    zeszyt_cen[i] = ogrodoo[i].sprzedaż();
                    }
                }
            try
                {
                Thread.sleep(1000);
                }
            catch(InterruptedException e)
                {
                System.out.println("ERROR!");
                }
            }
        raport();
        }
    }
