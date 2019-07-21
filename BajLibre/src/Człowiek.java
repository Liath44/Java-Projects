import java.util.ArrayList;


public abstract class Człowiek
    {
    protected ArrayList<Książka> pamięć;
    private Książka aktKsiążka;
    private ArrayList<StrategiaZapamiętywania> CharakterPamięci;

    public Człowiek(ArrayList<StrategiaZapamiętywania> CharakterPamięci)
        {
        pamięć = new ArrayList<>();
        aktKsiążka = null;
        this.CharakterPamięci = CharakterPamięci;
        }

    public abstract void Gawęduj();

    public void OKsiażce(Książka książka)
        {
        if(książka.getTytuł() != null)
            {
            System.out.println("Książka ma tytuł " + książka.getTytuł());
            }
        if(książka.getAutor() != null)
            {
            System.out.println("Autorem książki jest " + książka.getAutor());
            }
        if(książka.getRok() != null)
            {
            System.out.println("Książkę wydano w " + książka.getRok());
            }
        if(książka.getTreść() != null)
            {
            System.out.println(książka.getTreść());
            }
        }

    public void Czytaj()
        {
        String dodatkowe_info = "";
        for(int i = 0; i < CharakterPamięci.size(); ++i)
            {
            dodatkowe_info = dodatkowe_info + CharakterPamięci.get(i).Zapamiętuj(aktKsiążka);
            }
        pamięć.add(new Książka(aktKsiążka, dodatkowe_info));
        }

    public void setAktKsiążka(Książka książka)
        {
        aktKsiążka = książka;
        }

    public Książka getAktKsiążka()
        {
        Książka książka = aktKsiążka;
        aktKsiążka = null;
        return książka;
        }
    }
