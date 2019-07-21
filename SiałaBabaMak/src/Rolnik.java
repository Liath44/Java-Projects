import java.util.Random;
import java.util.ArrayList;

public abstract class Rolnik
    {
    protected Warzywo[] ogrod;
    protected long wydatki;
    protected ArrayList<Warzywo> zbiory;
    private Random r = new Random();

    public Rolnik(int k)
        {
        ogrod = new Warzywo[k];
        sadz(ogrod);
        wydatki = 0;
        zbiory = new ArrayList<Warzywo>();
        }

    public abstract void symuluj(Warzywo[] ogrodo, int time);

    protected Warzywo[] kopiuj_ogrod(Warzywo[] ogrodo)
        {
        Warzywo[] wynik = new Warzywo[ogrodo.length];
        for(int i = 0; i < ogrodo.length; ++i)
            {
            wynik[i] = ogrodo[i];
            wynik[i].narodziny = System.currentTimeMillis();
            }
        return wynik;
        }

    protected void raport()
        {
        System.out.println("Wydatki: " + wydatki + " PLN");
        long zysk = 0;
        int i = 0;
        Warzywo pom;
        while(i < zbiory.size())
            {
            pom = zbiory.get(i);
            zysk = zysk + pom.koszt;
            i++;
            }
        System.out.println("Sprzedaż: " + zysk + " PLN");
        System.out.print("Zebrano: ");
        while(!(zbiory.isEmpty()))
            {
            pom = zbiory.get(0);
            System.out.print(pom.nazwa + ", ");
            zbiory.remove(0);
            }
        System.out.print("\n\n");
        }

    protected void sadz_jeden(Warzywo[] ogrodo, int i)
        {
        int a = r.nextInt(3);
        if(a == 0)
            {
            Warzywo warz = new Pomidor();
            ogrodo[i] = warz;
            wydatki = wydatki + warz.koszt;
            }
        else if(a == 1)
            {
            Warzywo warz = new Ziemniak();
            ogrodo[i] = warz;
            wydatki = wydatki + warz.koszt;
            }
        else if(a == 2)
            {
            Warzywo warz = new Marchew();
            ogrodo[i] = warz;
            wydatki = wydatki + warz.koszt;
            }
        }

    protected void sadz(Warzywo[] ogrodo)
        {
        for(int i = 0; i < ogrodo.length; i++)
            {
            sadz_jeden(ogrodo, i);
            }
        }
    }
