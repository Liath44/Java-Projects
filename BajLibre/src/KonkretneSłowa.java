import java.util.ArrayList;

public class KonkretneSłowa extends StrategiaZapamiętywania
    {
    private ArrayList<String> słowa;

    public KonkretneSłowa(ArrayList<String> słowa)
        {
        this.słowa = słowa;
        }

    public String Zapamiętuj(Książka książka)
        {
        String wynik = "";
        String[] treść_książki = książka.getTreść().split(" ");//rozdziela stringa do tablicy / rozdzielnik to pojedyncza spacja
        for(int i = 0; i < słowa.size(); ++i)
            {
            int ilość = 0;
            for(int j = 0; j < treść_książki.length; ++j)
                {
                if(treść_książki[j].equals(słowa.get(i)))
                    {
                    ilość++;
                    }
                }
            wynik = wynik + "Słowo " + słowa.get(i) + " występuje " + ilość + " razy\n";
            }
        return wynik;
        }
    }
