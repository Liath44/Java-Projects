public class Długość extends StrategiaZapamiętywania
    {
    public Długość()
        {
        }

    public String Zapamiętuj(Książka książka)
        {
        String treść_książki = książka.getTreść();
        int licznik = 1;//załóżmy, że treść książki jest niepusta
        for(int i = 0; i < treść_książki.length(); ++i)
            {
            if(treść_książki.charAt(i) == ' ')
                {
                licznik++;
                }
            }
        return "W książce jest " + licznik + " wyrazów";
        }
    }
