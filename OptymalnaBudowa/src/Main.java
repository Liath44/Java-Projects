/*
Zadanie zaliczeniowe 1
Programowanie Obiektowe - laboratorium
Maciej Dragun <m.dragun2@student.uw.edu.pl> <md406129@students.mimuw.edu.pl>
Wersja 0.85
Data: 23.04.2019

Program symuluje wykonanie pewnego projektu według pewnego cennika według
jednej z czterech strategii: minimalistycznej, maksymalistycznej, ekonomicznej,
ekologicznej. Zawartość cennika, projektu i wybór przyjmowanej strategii ustalane
są przez użytkownika.

Więcej info odnośnie zadania: https://moodle.mimuw.edu.pl/mod/assign/view.php?id=14307

Założenia:
 - Dane ustalające cennik, projekt i strategię są określonego formatu
 ustalonego na stronie powyżej
 - Wszystkie dane mieszczą się w zakresie typu int
 - Projekt dla danego cennika jest wykonywalny

Zawartość plików typu .java w projekcie: Main, Pręt, Kupiec, Maksymalista, Minimalista, Ekonomista, Ekologista, Optymalista
*/

import java.util.Objects;
import java.util.Scanner;

public class Main
    {
    //uzupełnia cennik wprowadzany przez użytkownika
    private static void uzupelnij_cennik(Pręt[] cennik, Scanner scanf)
        {
        int i = 0;
        while(i < cennik.length)
            {
            int długość = scanf.nextInt();
            int cena = scanf.nextInt();//odczyt parametrów wpisanych przez użytkownika
            Pręt pręt = new Pręt(długość, cena);//tworzenie pręta na podstawie podanych danych
            cennik[i] = pręt;//ustawienie odpowiedniej wartości w tablicy
            ++i;
            }
        }

    //uzupełnia projekt wprowadzany przez uzytkownika
    private static void uzupelnij_projekt(int[] projekt, Scanner scanf)
        {
        int i = 0;
        while(i < projekt.length)
            {
            int potrzeba = scanf.nextInt();//odczytuje konkretną część projektu i przypisuje do odpowiedniego miejsca w tablicy
            projekt[i] = potrzeba;
            ++i;
            }
        }

    public static void main(String[] args)
        {
        Scanner scanf = new Scanner(System.in);
        int c = scanf.nextInt();//odczyt rozmiaru cennika
        Pręt[] cennik = new Pręt[c];
        uzupelnij_cennik(cennik, scanf);//uzupełnia cennik o dane wprowadzane przez użytkownika
        int p = scanf.nextInt();//odczyt rozmiaru projektu
        int[] projekt = new int[p];
        uzupelnij_projekt(projekt, scanf);//uzupełnia projekt o dane wprowadzane przez użytkownika
        String strategia = scanf.nextLine();//tutaj chyba jjemy pustego stringa - w każdym razie działa
        strategia = scanf.nextLine();//odczyt nazwy przyjmowanej strategii zakupu
        if(Objects.equals(strategia, "minimalistyczna"))
            {
            Kupiec ZarturAroda = new Minimalista(p);
            ZarturAroda.kupuj(cennik, projekt);
            ZarturAroda.raport();
            }
        if(Objects.equals(strategia, "maksymalistyczna"))
            {
            Kupiec JabuszJanłonowski = new Maksymalista(p);
            JabuszJanłonowski.kupuj(cennik, projekt);//przeprowadza zakup prętów według podanej strategii, cennika i projektu
            JabuszJanłonowski.raport();//wypisuje rezultat zakupów tj. efekt działania metody kupuj
            }
        if(Objects.equals(strategia, "ekonomiczna"))
            {
            Kupiec CzonradKehowicz = new Ekonomista(p);
            CzonradKehowicz.kupuj(cennik, projekt);
            CzonradKehowicz.raport();
            }
        if(Objects.equals(strategia, "ekologiczna"))
            {
            Kupiec ChiotrWrząstowskiPachtel = new Ekologista(p);
            ChiotrWrząstowskiPachtel.kupuj(cennik, projekt);
            ChiotrWrząstowskiPachtel.raport();
            }
        }
    }
