import java.util.ArrayList;

public class Wszystkie extends Człowiek
    {
    public Wszystkie(ArrayList<StrategiaZapamiętywania> CharakterPamięci)
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
            for(int i = 0; i < pamięć.size(); ++i)
                {
                OKsiażce(pamięć.get(i));
                }
            }
        }
    }
