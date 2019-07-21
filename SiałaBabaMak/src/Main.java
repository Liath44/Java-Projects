//nareperować
//Dodać funkcję sadz do inicjalizacji ogrodu danego rolnika
//usunąć inicjalizowanie ogrodu w symulacjach
//podreperować symulacje by działały dla nowej poprawnej interpretacji treści
//to powinno dawać radę
import java.util.ArrayList;

public class Main
    {
    public static void main(String[] args)
        {
        Rolnik Marek = new PracownikPGR(5);
        Marek.symuluj(Marek.ogrod, 30);
        Rolnik Stefan = new PracownikPGR(5);
        Stefan.symuluj(Marek.ogrod, 30);
        Rolnik Andrzej = new Gospodarz(5);
        Andrzej.symuluj(Marek.ogrod, 30);
        System.out.print("\n");
        System.out.println("--- END ---");

        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        l1.add(1);
        l2 = l1;
        System.out.println(l2.get(0));
        }
    }
