public class Calkowite extends Algebraiczne<Calkowite>
    {
    private Integer wartosc;

    public Calkowite(Integer wartosc)//konstruktor
        {
        this.wartosc = wartosc;
        }

    public Integer getWartosc()//getter
        {
        return wartosc;
        }

    public Calkowite dodawaj(Calkowite c)
        {
        return new Calkowite(wartosc + c.getWartosc());
        }

    public Calkowite mnoz(Calkowite c)
        {
        return new Calkowite(wartosc * c.getWartosc());
        }

    public void wypisz()
        {
        System.out.println(wartosc);
        }

    public int porownoj(Calkowite c)
        {
        return Integer.compare(wartosc, c.getWartosc());
        }
    }
