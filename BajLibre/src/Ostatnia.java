import java.util.ArrayList;

public class Ostatnia extends Człowiek
    {
    public Ostatnia(ArrayList<StrategiaZapamiętywania> CharakterPamięci)
        {
        super(CharakterPamięci);
        }

    public void Gawęduj()
        {
        if(pamięć.size() == 0)
            {
            System.out.println("Nie czytałem jeszcze żadnej książki");
            }
        else
            {
            OKsiażce(pamięć.get(pamięć.size() - 1));
            }
        }
    }
