import java.util.ArrayList;

public class Biblioteka
    {
    private ArrayList<Książka> księgozbiór;
    private int limit_książek;//lepszą nazwą byłby limit wypożyczeń

    public Biblioteka(ArrayList<Książka> księgozbiór, int n)
        {
        this.księgozbiór = księgozbiór;
        limit_książek = n;
        }

    public void SymulujDzien(ArrayList<Człowiek> kolejka)
        {
        int i = 0;
        while(i < limit_książek)
        }
    }
