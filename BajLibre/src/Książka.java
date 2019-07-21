import java.util.Random;

public class Książka
    {
    private static final Random r = new Random();
    private String autor;
    private String tytuł;
    private Integer rok;
    private String treść;

    public Książka(String autor, String tytuł, Integer rok, String treść)
        {
        this.autor = autor;
        this.tytuł = tytuł;
        this.rok = rok;
        this.treść = treść;
        }

    public Książka(Książka książka, String zapamiętane_info)
        {
        if(r.nextBoolean())
            {
            autor = książka.getAutor();
            }
        else
            {
            autor = null;
            }
        if(r.nextBoolean())
            {
            tytuł = książka.getTytuł();
            }
        else
            {
              tytuł = null;
            }
        if(r.nextBoolean())
            {
            rok = książka.getRok();
            }
        else
            {
            rok = null;//gdyby rok był intem a nie Integerem to by nie działało
            }
        treść = zapamiętane_info;
        }

    public String getAutor()
        {
        return autor;
        }

    public String getTytuł()
        {
        return tytuł;
        }

    public Integer getRok()
        {
        return rok;
        }

    public String getTreść()
        {
        return treść;
        }
    }
