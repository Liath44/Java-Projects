import java.util.LinkedList;

public class Ekologista extends Optymalista
    {

    //jedyna różnica między ekologistą a ekonomistą leży w warunku sprawdzania efektywnego rozwiązania
    //tak to robi to samo co ekonomista ergo komentarz jest zbędny

    /*
    int wydatki;
    int odpady;
    LinkedList<Integer> podziały;
    protected LinkedList<Integer> koszyk;
    int[] wykonanie;
    */

    public Ekologista(int p)
        {
        super(p);
        }

    protected void przydział_pręta(int n, int pom_wydatki, LinkedList<Integer> pom_podziały, int[] pom_wykonanie, Pręt[] cennik, int[] projekt, LinkedList<Integer> pom_koszyk, int pom_odpady)
        {
        int a = n;
        while(a >= 0 && pom_wykonanie[a] == projekt[a])
            {
            --a;
            }
        if(a < 0 && pom_odpady < odpady)//tym razem interesuje nas szukanie opcji efektywnej względem małości produkowanych odpadów
            {
            finalizuj_projekt(pom_odpady, pom_wydatki, pom_podziały, pom_koszyk);
            }
        else if(pom_odpady < odpady)//tym razem interesuje nas szukanie opcji efektywnej względem małości produkowanych odpadów
            {
            int i = cennik.length - 1;
            while(i >= 0 && projekt[a] <= cennik[i].długość)
                {
                zdecyduj_sie_na_zakup(i, a, pom_wydatki, pom_odpady, pom_podziały, pom_koszyk, cennik, projekt, pom_wykonanie);
                --i;
                }
            }
        }
    }