import java.util.LinkedList;

public abstract class Optymalista extends Kupiec
    {
    //pewne operacje są współdzielone przez klasy Ekonomista i Ekologista
    //ta klasa jest po to by spiąć ze sobą te wspólne metody
    //pola klasy przechowują aktualnie nam znaną najefektywniejszą opcję

    //Optymaliści do n-tej pozycji w projekcie przydzielają każdy możliwy pasujący pręt
    //i wykonują każde możliwe przydzielenie odciętej części.
    //Następnie wykonuja tę operację dla n-1-tej pozycji w projekcie.
    //Względnie na bieżąco Optymaliści sprawdzają czy w dalszym ciągu opłaca im się
    //kontynuowanie projektu wedle pewnych warunków.
    //Ekonomista dąży do wykonania projektu najmniejszym kosztem.
    //Ekologista dąży do wykonania projektu produkując najmniejszą ilość odpadów.

    /*
    int wydatki;
    int odpady;
    LinkedList<Integer> podziały;
    protected LinkedList<Integer> koszyk;
    int[] wykonanie;
    */

    public Optymalista(int p)
        {
        super(p);
        }

    //jeżeli znaleźniśmy optymalniejszą opcję to nadpisujemy poszczególne atrybuty klasowe
    private void przypisz_koszyk(LinkedList<Integer> pom_koszyk)
        {
        koszyk.clear();
        int i = 0;
        while(i < pom_koszyk.size())
            {
            koszyk.add(pom_koszyk.get(i));
            ++i;
            }
        }

    //jeżeli znaleźniśmy optymalniejszą opcję to nadpisujemy poszczególne atrybuty klasowe
    private void przypisz_podziały(LinkedList<Integer> pom_podziały)
        {
        podziały.clear();
        int i = 0;
        while(i < pom_podziały.size())
            {
            podziały.add(pom_podziały.get(i));
            ++i;
            }
        }

    //dla danej odciętej części pręta wykorzystuje ją (o ile się da) na każdy możliwy sposób
    //na koniec rozwiązuje problem przydział_pręta dla n-1; do tego służy nam zmienna pomocnicza "powrót"
    private void dziel_resztkę(int n, int pom_wydatki, LinkedList<Integer> pom_podziały, int[] pom_wykonanie, Pręt[] cennik, int[] projekt, int resztka, LinkedList<Integer> pom_koszyk, int powrót, int pom_odpady)
        {
        int a = n - 1;
        int reszta = resztka;
        while(a >= 0 && pom_wykonanie[a] == projekt[a])//te części projektu są już wykonane
            {
            --a;
            }
        if(a >= 0 && resztka >= projekt[a])//używamy resztki lub szukamy dalej (dziel resztkę)
            {
            dziel_resztkę(a, pom_wydatki, pom_podziały, pom_wykonanie, cennik, projekt, resztka, pom_koszyk, powrót, pom_odpady);//szukamy dalej czy też wykorzystujemy resztkę gdzie indziej
            if(pom_podziały.get(pom_podziały.size() - 1) == -1)//poprzednia funkcja mogła nam dodać -1 gdy nie podzieliła pręta wcale
                {
                pom_podziały.remove(pom_podziały.size() - 1);
                }
            int pamiętaj = pom_podziały.size();//będziemy chcieć powracać do stanu wyjściowego
            pom_podziały.add(projekt[a]);//używamy resztki
            pom_wykonanie[a] = projekt[a];
            dziel_resztkę(a, pom_wydatki, pom_podziały, pom_wykonanie, cennik, projekt, resztka - projekt[a], pom_koszyk, powrót, pom_odpady);//działamy na resztce z resztki
            while(pom_podziały.size() != pamiętaj)//powrót do stanu wyjściowego
                {
                pom_podziały.remove(pom_podziały.size() - 1);
                }
            pom_wykonanie[a] = 0;
            }
        else if(a >= 0 && resztka < projekt[a])//szukamy dalej - resztka jest za krótka
            {
            dziel_resztkę(a, pom_wydatki, pom_podziały, pom_wykonanie, cennik, projekt, resztka, pom_koszyk, powrót, pom_odpady);
            }
        else// a < 0 już nie mamy czego i jak uzupełniać
            {
            if(pom_podziały.get(pom_podziały.size() - 1) != -1)//jeśli jest potrzeba zaznaczenia, że zakończyliśmy dzielenie pręta to to robimy - po prostu czasem przy braku podziału pręta nie pojawiała nam się -1 na końcu listy podziałowej
                {
                pom_podziały.add(-1);
                }
            pom_odpady = pom_odpady + resztka;//dodajemy odpad, który nam pozostał
            przydział_pręta(powrót - 1, pom_wydatki, pom_podziały, pom_wykonanie, cennik, projekt, pom_koszyk, pom_odpady);//tą funkcją chcemy wracać do dalszego przydzielania pręta
            }
        }

    //funkcja odpowiedzialna za wykonanie projektu
    public void kupuj(Pręt[] cennik, int[] projekt)
        {
        if(cennik.length == 0)
            {
            wydatki = 0;//projekt jest pusty i nie będzie czego wykonywać
            odpady = 0;
            }
        else
            {
            wydatki = cennik[cennik.length - 1].cena * (projekt.length) + 1;//jeżeli projekt nie jest pusty wydatki ustawiamy na opcję pesymistyczną
            odpady = cennik[cennik.length - 1].długość * (projekt.length) + 1;// przydatne w pierwszych chwilach istnienia funkcji przdział_pręta
            }
        //pomocnicze atrybuty służące do przechowywania aktualnie rozpatrywanej opcji
        int pom_wydatki = 0;
        int pom_odpady = 0;
        LinkedList<Integer> pom_podziały = new LinkedList<Integer>();
        pom_podziały.add(-1);
        LinkedList<Integer> pom_koszyk = new LinkedList<Integer>();
        int[] pom_wykonanie = new int[wykonanie.length];
        przydział_pręta(projekt.length - 1, pom_wydatki, pom_podziały, pom_wykonanie, cennik, projekt, pom_koszyk, pom_odpady);//rozpoczyna faktyczne zakupy pręta
        }

    //wywoływana wtedy gdy znaleźliśmy bardziej efektywną opcję
    //atrybuty klasowe są nadpisywane
    protected void finalizuj_projekt(int pom_odpady, int pom_wydatki, LinkedList<Integer> pom_podziały, LinkedList<Integer> pom_koszyk)
        {
        odpady = pom_odpady;
        wydatki = pom_wydatki;
        przypisz_podziały(pom_podziały);
        przypisz_koszyk(pom_koszyk);
        }

    //kupuje dany pręt, zastanawia się co zrobić z resztką wywołując dziel_resztkę i poprzez nią kontynuuje wykonywanie projektu; tj. dziel_resztkę wywołuje przydział_pręta
    protected void zdecyduj_sie_na_zakup(int i, int a, int pom_wydatki, int pom_odpady, LinkedList<Integer> pom_podziały, LinkedList<Integer> pom_koszyk, Pręt[] cennik, int[] projekt, int[] pom_wykonanie)
        {
        pom_wydatki = pom_wydatki + cennik[i].cena;//kupujemy dany pręt
        int pamiętaj = pom_podziały.size();//służy do powrotu do stanu wyjściowego tj. sprawdzenia co się dzieje dla innego pręta
        pom_podziały.add(projekt[a]);//dzielimy pręt
        pom_wykonanie[a] = projekt[a];
        pom_koszyk.add(cennik[i].długość);
        dziel_resztkę(a, pom_wydatki, pom_podziały, pom_wykonanie, cennik, projekt, cennik[i].długość - projekt[a], pom_koszyk, a, pom_odpady);//działamy na odciętej części pręta
        pom_koszyk.remove(pom_koszyk.size() - 1);//powrót do stanu wyjściowego tj. co się będzie dziać dla innego pręta
        pom_wydatki = pom_wydatki - cennik[i].cena;
        while(pom_podziały.size() != pamiętaj)
            {
            pom_podziały.remove(pom_podziały.size() - 1);
            }
        pom_wykonanie[a] = 0;
        }

    //Ekonomista i Ekologista decydują się na kontynuowanie przydzielania pręta na podstawie innych warunków
    protected abstract void przydział_pręta(int n, int pom_wydatki, LinkedList<Integer> pom_podziały, int[] pom_wykonanie, Pręt[] cennik, int[] projekt, LinkedList<Integer> pom_koszyk, int pom_odpady);
    }
