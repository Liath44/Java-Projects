public class Wektor<T extends Algebraiczne<T>>
    {
    private T wsp_x;
    private T wsp_y;

    public Wektor(T wsp_x, T wsp_y)
        {
        this.wsp_x = wsp_x;
        this.wsp_y = wsp_y;
        }

    private T getwsp_x()
        {
        return wsp_x;
        }

    private T getwsp_y()
        {
        return wsp_y;
        }

    private void sprawdz_dlugosc(Wektor<T> wektor2) throws RóżnaDługośćWektorów
        {
        T długość1 = (wsp_x.mnoz(wsp_x)).dodawaj(wsp_y.mnoz(wsp_y));
        T długość2 = (wektor2.getwsp_x().mnoz(wektor2.getwsp_x())).dodawaj((wektor2.getwsp_y().mnoz(wektor2.getwsp_y())));
        if(długość1.porownoj(długość2) != 0)
            {
            System.out.print("Długość pierwszego wektora: ");
            długość1.wypisz();
            System.out.print("Długość drugiego wektora: ");
            długość2.wypisz();
            throw new RóżnaDługośćWektorów();
            }
        }

    public T iloczyn_skalarny(Wektor<T> wektor2) throws RóżnaDługośćWektorów
        {
        sprawdz_dlugosc(wektor2);
        return wsp_x.mnoz(wektor2.getwsp_x()).dodawaj(wsp_y.mnoz(wektor2.getwsp_y()));
        }

    public Wektor<T> suma_wektorów(Wektor<T> wektor2) throws RóżnaDługośćWektorów
        {
        sprawdz_dlugosc(wektor2);
        return new Wektor<T>(wsp_x.dodawaj(wektor2.getwsp_x()), wsp_y.dodawaj(wektor2.getwsp_y()));
        }

    public void wypisz()
        {
        System.out.print("Współrzędna 1: ");
        wsp_x.wypisz();
        System.out.print("Współrzędna 2: ");
        wsp_y.wypisz();
        }
    }
