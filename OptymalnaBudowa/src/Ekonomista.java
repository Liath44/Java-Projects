import java.util.LinkedList;

public class Ekonomista extends Optymalista
    {
    //pola klasy przechowują aktualnie nam znaną najefektywniejszą opcję
    /*
    int wydatki;
    int odpady;
    LinkedList<Integer> podziały;
    protected LinkedList<Integer> koszyk;
    int[] wykonanie;
    */

    public Ekonomista(int p)
        {
        super(p);
        }

    //funkcja dla pozycji n-tej przydziela każdy możliwy pręt
    //następnie rozpatruje wszelkie możliwe kombinacje przydzieleń resztki z odciętego pręta
    protected void przydział_pręta(int n, int pom_wydatki, LinkedList<Integer> pom_podziały, int[] pom_wykonanie, Pręt[] cennik, int[] projekt, LinkedList<Integer> pom_koszyk, int pom_odpady)
        {
        //Dla liczb większych od n problem jest już rozwiązany
        int a = n;
        while(a >= 0 && pom_wykonanie[a] == projekt[a])//być może na tej pozycji projekt jest już wykonany
            {
            --a;
            }
        if(a < 0 && pom_wydatki < wydatki)//projekt został wykonany; warunek pom_wydatki < wydatki sprawdza czy dana opcja jest efektywniejsza od tego co już mamy
            {
            finalizuj_projekt(pom_odpady, pom_wydatki, pom_podziały, pom_koszyk);//to wykonanie projektu jest najefektywniejsze - zapisuje je w klasie
            }
        else if(pom_wydatki < wydatki)//nie kontynuujemy danej opcji jeśli wiemy, że nie będzie ona nas zadowalała
            {
            int i = cennik.length - 1;//do iteracji po cenniku
            while(i >= 0 && projekt[a] <= cennik[i].długość)//sprawdzamy dla każdego możliwego pasującego prętu
                {
                zdecyduj_sie_na_zakup(i, a, pom_wydatki, pom_odpady, pom_podziały, pom_koszyk, cennik, projekt, pom_wykonanie);//kupuje dany pręt - podczas zakupu rozmyśla nad podziałami i zakupem kolejnego pręta
                --i;
                }
            }
        }
    }
