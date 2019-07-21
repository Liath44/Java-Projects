import java.util.LinkedList;

public abstract class Kupiec
    {
    protected int wydatki;  //ile kosztować nas będą zakupy
    protected int odpady;    //ile odpadów wyprodukujemy przy danym wykonaniu projektu
    protected LinkedList<Integer> koszyk;//jakie pręty kupimy
    protected LinkedList<Integer> podziały;//podziały zakupionych prętów przetrzymywane są w następujący sposób:
    //(-1) (spis odcinków na które podzieliliśmy pręt) (-1) (spis odcinków na które podzieliliśmy pręt) (-1) ... (-1)
    //np. (-1) 10 20 (-1) 40 10 30 (-1)
    protected int[] wykonanie;//rozmiaru tablicy projektowej - używane w funkcji kupuj do sprawdzania co jest już wykonane w projekcie a co nie

    public Kupiec(int p)
        {
        wydatki = 0;
        odpady = 0;
        koszyk = new LinkedList<Integer>();
        podziały = new LinkedList<Integer>();
        podziały.add(-1);
        wykonanie = new int[p];
        }

    public void raport()//wypisuje rezultat zakupów tj. efekt działania metody kupuj
        {
        System.out.println(wydatki);
        System.out.println(odpady);
        podziały.remove(0);//usuwa z listy podziałów pierwszą -1
        while(!podziały.isEmpty())
            {
            System.out.print(koszyk.get(0) + " ");//wypisujemy długość prętu, który dzielimy
            koszyk.remove(0);
            while(podziały.get(1) != -1)
                {
                System.out.print(podziały.get(0) + " ");//wypisujemy podziały aż do momentu gdy dany podział nie jest ostatnim podziałem
                podziały.remove(0);
                }
            System.out.println(podziały.get(0));//wypisujemy ostatni podział
            podziały.remove(0);
            podziały.remove(0);//usunięcie -1
            }
        }

    public abstract void kupuj(Pręt[] cennik, int[] projekt);//dla każdej strategii proces zakupu jest odmienny
    }
