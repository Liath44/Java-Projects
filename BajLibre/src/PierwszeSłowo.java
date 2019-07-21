public class PierwszeSłowo extends StrategiaZapamiętywania
    {
    public PierwszeSłowo()
        {
        }

    public String Zapamiętuj(Książka książka)
        {
        String treść_książki = książka.getTreść();
        String wynik = "";
        int i = 0;
        while(treść_książki.charAt(i) != '\0' || treść_książki.charAt(i) != ' ')
            {
            wynik = wynik + treść_książki.charAt(i);//Do Stringów można dodawać chary
            ++i;
            }
        return "Pierwszym słowem książki jest " + wynik;
        }
    }
