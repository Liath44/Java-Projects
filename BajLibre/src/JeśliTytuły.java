import java.util.ArrayList;

public class JeśliTytuły extends Człowiek
    {
    public JeśliTytuły(ArrayList<StrategiaZapamiętywania> CharakterPamięci)
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
                if(pamięć.get(i).getTytuł() != null)
                    {
                    OKsiażce(pamięć.get(i));
                    }
                }
            }
        }
    }
