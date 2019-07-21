public class Zmiennoprzecinkowe extends Algebraiczne<Zmiennoprzecinkowe>
    {
    private Double wartosc;

    public Zmiennoprzecinkowe(Double wartosc)//konstruktor
        {
        this.wartosc = wartosc;
        }

    private Double getWartosc()//getter
        {
        return wartosc;
        }

    public Zmiennoprzecinkowe dodawaj(Zmiennoprzecinkowe c)
        {
        return new Zmiennoprzecinkowe(wartosc + c.getWartosc());
        }

    public Zmiennoprzecinkowe mnoz(Zmiennoprzecinkowe c)
        {
        return new Zmiennoprzecinkowe(wartosc * c.getWartosc());
        }

    public void wypisz()
        {
        System.out.println(wartosc);
        }

    public int porownoj(Zmiennoprzecinkowe c)
        {
        return Double.compare(wartosc, c.getWartosc());
        }
    }
