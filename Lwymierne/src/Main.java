import Liczby.L.Wymierne;

import java.util.ArrayList;

public class Main
{
public static void main(String[] args)
    {
    Wymierne a = new Wymierne(3, 4);
    Wymierne b = new Wymierne(-7, 6);
    Wymierne b2 = new Wymierne(7, -6);
    Wymierne c = a.przeciwna();
    Wymierne d = b.odwrotna();
    Wymierne e = Wymierne.zero();
    Wymierne f = Wymierne.jeden();
    Wymierne g = b.dodawaj(a);
    Wymierne h = b.odejmuj(a);
    Wymierne i = a.odejmuj(b);
    Wymierne k = a.mnoz(b);
    Wymierne l = b.mnoz(a);
    Wymierne m = a.dziel(b);
    Wymierne n = b.dziel(a);
    int znak = b2.get_znak();
    int licznik = b2.get_licznik();
    int mianownik = b2.get_mianownik();
    int wynik_porownania = a.porownoj(b);
    int wynik_porownania_2 = b.porownoj(a);
    int wynik_porownania_3 = a.porownoj(a);
    Wymierne o = new Wymierne(3);
    Wymierne p = new Wymierne(0);
    //Wymierne q = new Wymierne(0,0);
    //działa^
    //Wymierne r = e.odwrotna();
    //działa^

    a.wypisz();
    b.wypisz();
    b2.wypisz();
    c.wypisz();
    d.wypisz();
    e.wypisz();
    f.wypisz();
    g.wypisz();
    h.wypisz();
    i.wypisz();
    k.wypisz();
    l.wypisz();
    m.wypisz();
    n.wypisz();
    System.out.println(znak);
    System.out.println(licznik);
    System.out.println(mianownik);
    System.out.println(wynik_porownania);
    System.out.println(wynik_porownania_2);
    System.out.println(wynik_porownania_3);
    o.wypisz();
    p.wypisz();
    //q.wypisz();
    //r.wypisz();

    ArrayList<Wymierne> lista = new ArrayList<>();
    lista.add(new Wymierne(2, 3));
    if(lista.contains(new Wymierne(4,6)));
        {
        System.out.println("ok");
        }
    }
}
