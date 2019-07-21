public class Minimalista extends Kupiec
    {
    /*
    int wydatki;
    int odpady;
    protected LinkedList<Integer> koszyk;
    LinkedList<Integer> podziały;
    int[] wykonanie;
    */

    public Minimalista(int p)
        {
        super(p);
        }

    //wykonuje projekt wedle startegii minimalistycznej
    //Dopóki problem nie jest rozwiązany, z cennika wybiera najkrótszy pręt, w którym mieści się najdłuższy brakujący odcinek.
    // Następnie rozważa brakujące odcinki w kolejności od najdłuższych.
    // Jeśli rozważany odcinek mieści się w części pręta, która jeszcze pozostała, jest od niej odcinany.
    // To, co zostanie z pręta, po rozważeniu ostatniego odcinka, jest odpadem.
    public void kupuj(Pręt[] cennik, int[] projekt)
        {
        int n = wykonanie.length - 1;
        while(n >= 0)
            {
            if(wykonanie[n] == projekt[n])//niektóre części projektu mogly zostać już wykonane
                {
                --n;
                }
            else
                {
                boolean wybrano = false;
                int i = 0;
                while(!wybrano)//szukamy odpowiedniego pręta do przypasowania do aktualnego zapotrzebowania w projekcie
                    {
                    if(cennik[i].długość < projekt[n])//nie pasuje nam pręt
                        {
                        ++i;
                        }
                    else//cennik[i].długość >= projekt[n] - pręt pasuje
                        {
                        wybrano = true;
                        wydatki = wydatki + cennik[i].cena;//zakup pręta
                        koszyk.add(cennik[i].długość);
                        podziały.add(projekt[n]);
                        wykonanie[n] = projekt[n];//wykonujemy ten etap projektu
                        }
                    }
                int pozostałość = cennik[i].długość - projekt[n];//reszta po odcięciu potrzebnego kawałka
                int m = n - 1;//m - służy do dokładania do pozostałych prętów
                while(m >= 0 && pozostałość > 0)//szukamy gdzie możemy użyć naszej pozostałości
                    {
                    if(projekt[m] <= pozostałość && wykonanie[m] != projekt[m])// jeśli pozostałość nam pasuje do danej części projektu i nie jest on jeszcze wykonany
                        {
                        wykonanie[m] = projekt[m];
                        pozostałość = pozostałość - projekt[m];
                        podziały.add(projekt[m]);//dzielimy dany pręt tudzież jego resztkę
                        --m;
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
