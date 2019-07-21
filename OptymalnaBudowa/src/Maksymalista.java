public class Maksymalista extends Kupiec
    {
    /*
    int wydatki;
    int odpady;
    protected LinkedList<Integer> koszyk;
    LinkedList<Integer> podziały;
    int[] wykonanie;
    */

    public Maksymalista(int p)
        {
        super(p);
        }

    //wykonuje projekt wedle startegii maksymalistycznej
    //Dopóki problem nie jest rozwiązany, z cennika wybiera najdłuższy pręt, w którym mieści się najdłuższy brakujący odcinek.
    // Następnie rozważa brakujące odcinki w kolejności od najdłuższych.
    // Jeśli rozważany odcinek mieści się w części pręta, która jeszcze pozostała, jest od niej odcinany.
    // To, co zostanie z pręta, po rozważeniu ostatniego odcinka, jest odpadem.
    public void kupuj(Pręt[] cennik, int[] projekt)
        {
        int n = wykonanie.length - 1;
        int i = cennik.length - 1;
        while(n >= 0)
            {
            if(wykonanie[n] == projekt[n])//niektóre części projektu mogly zostać już wykonane
                {
                --n;
                }
            else
                {
                wydatki = wydatki + cennik[i].cena;//kupujemy najdłuższy pręt
                koszyk.add(cennik[i].długość);//kupujemy najdłuższy pręt
                podziały.add(projekt[n]);//dzielimy pręt raz
                wykonanie[n] = projekt[n];
                int pozostałość = cennik[i].długość - projekt[n];//pozostała część pręta - być może uda nam się nią uzupełnić inne części projektu
                int m = n - 1;//m - służy do dokładania do pozostałych prętów
                while(m >= 0 && pozostałość > 0)//sprawdzamy czy coś da się zrobić z pozostałością
                    {
                    if(projekt[m] <= pozostałość && wykonanie[m] != projekt[m])//jeśli możemy wykorzystać pozostałość i nie wykonaliśmy jeszcze tego etapu projektu
                        {
                        wykonanie[m] = projekt[m];
                        pozostałość = pozostałość - projekt[m];
                        podziały.add(projekt[m]);//dzielimy dany pręt tudzież jego resztkę
                        --m;//wykonujemy daną część projektu
                        }
                    else
                        {
                        --m;
                        }
                    }
                odpady = odpady + pozostałość;//odpady
                podziały.add(-1);//kończy podział pręta dodając -1 na koniec listy podziałowej
                --n;
                }
            }
        }
    }
