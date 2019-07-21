public class Wymierne extends Algebraiczne<Wymierne>
    {
    private int licznik;
    private int mianownik;
    private int znak;

    public static Wymierne zero()
        {
        return new Wymierne(0);
        }

    public static Wymierne jeden()
        {
        return new Wymierne(1);//i tu
        }

    public Wymierne przeciwna()
        {
        return new Wymierne(znak * (-1) * licznik, mianownik);//o, tu też
        }

    public Wymierne odwrotna()
        {
        if(znak == 0)
            {
            int c = 1/znak;
            }
        Wymierne wynik = new Wymierne(mianownik, licznik);
        wynik.znak = znak;
        return wynik;
        }

    private void uprosc(Wymierne liczba)
        {
        int nwd = NWD(liczba.mianownik, liczba.licznik);
        liczba.licznik = liczba.licznik/nwd;
        liczba.mianownik = liczba.mianownik/nwd;
        }

    private int NWD(int a, int b)
        {
        int c = a;
        int d = b;
        while (c != d)
            {
            if(c > d)
                {
                c = c - d;
                }
            else
                {
                d = d - c;
                }
            }
        return c;
        }

    private int NWW(int a, int b)
        {
        int c = NWD(a, b);
        return (a * b)/c;
        }

    public Wymierne dodawaj(Wymierne w)
        {
        int nww = NWW(mianownik, w.mianownik);
        int mnoz_pom_a = nww / mianownik;
        int mnoz_pom_b = nww / w.mianownik;
        Wymierne wynik = new Wymierne(znak * mnoz_pom_a * licznik + w.znak * mnoz_pom_b * w.licznik, nww);//you get the point
        if (wynik.licznik == 0)
            {
            return zero();
            }
        else if(wynik.licznik == wynik.mianownik)
            {
            return jeden();
            }
        return wynik;
        }

    public Wymierne odejmuj(Wymierne w)
        {
        Wymierne wynik = new Wymierne(w.licznik, w.mianownik);
        wynik.znak = w.znak * (-1);
        return dodawaj(wynik);
        }

    public Wymierne mnoz(Wymierne w)
        {
        if(w.licznik == 0 || licznik == 0)
            {
            return zero();
            }
        Wymierne wynik  = new Wymierne(znak * w.znak * w.licznik * licznik, w.mianownik * mianownik );//wracając
//        if(wynik.licznik == wynik.mianownik)
//            {
//            if(wynik.znak == 1)
//                {
//                return jeden();
//                }
//            else
//                {
//                wynik = jeden();
//                wynik.znak = -1;
//                return wynik;
//                }
//            }
        uprosc(wynik);
        return wynik;
        }

    public Wymierne dziel(Wymierne w)
        {
        return mnoz(w.odwrotna());
        }

    public int get_znak()
        {
        return znak;
        }

    public int get_licznik()
        {
        return licznik;
        }

    public int get_mianownik()
        {
        return mianownik;
        }

    public int porownoj(Wymierne w)
        {
        if(znak * licznik * w.mianownik < w.znak * w.licznik * mianownik)
            {
            return -1;
            }
        else if(znak * licznik * w.mianownik == w.znak * w.licznik * mianownik)
            {
            return 0;
            }
        else
            {
            return 1;
            }
        }

    public void wypisz()
        {
        if(znak == -1)
            {
            System.out.println("-" + licznik + "/" + mianownik);
            }
        else
            {
            System.out.println(licznik + "/" + mianownik);
            }
        }

    public Wymierne(int n, int q)
        {
        int wyzn_znak = n * q;
        if(n < 0)
            {
            licznik = n * (-1);
            }
        else
            {
            licznik = n;
            }
        if(q < 0)
            {
            mianownik = q * (-1);
            }
        else
            {
            mianownik = q;
            }
        if(q == 0)
            {
            int c = 1/q;
            }
        int nwd = NWD(licznik, mianownik);
        licznik = licznik/nwd;
        mianownik = mianownik/nwd;
        if(wyzn_znak > 0)
            {
            znak = 1;
            }
        else if(wyzn_znak < 0)
            {
            znak = -1;
            }
        else
            {
            znak = 0;
            }
        }

    public Wymierne(int n)
        {
        mianownik = 1;
        if(n < 0)
            {
            znak = -1;
            licznik = (-1) * n;
            }
        else if(n == 0)
            {
            licznik = n;//dlaczego IDE czepia się tego fragmentu (***)
            znak = 0;
            }
        else
            {
            licznik = n;
            znak = 1;
            }
        }
    }