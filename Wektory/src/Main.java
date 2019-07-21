public class Main
    {
    public static void main(String[] args)
        {
        Wektor<Calkowite> w1 = new Wektor<Calkowite>(new Calkowite(-3), new Calkowite(6));
        Wektor<Calkowite> w2 = new Wektor<Calkowite>(new Calkowite(3), new Calkowite(-6));
        try
            {
            Calkowite ilo12 = w1.iloczyn_skalarny(w2);
            ilo12.wypisz();
            }
        catch(RóżnaDługośćWektorów a)
            {
            }

        Wektor<Zmiennoprzecinkowe> w3 = new Wektor<Zmiennoprzecinkowe>(new Zmiennoprzecinkowe(2.5), new Zmiennoprzecinkowe(-3.0));
        Wektor<Zmiennoprzecinkowe> w4 = new Wektor<Zmiennoprzecinkowe>(new Zmiennoprzecinkowe(4.0), new Zmiennoprzecinkowe(-3.0));
        try
            {
            Zmiennoprzecinkowe ilo34 = w3.iloczyn_skalarny(w4);
            ilo34.wypisz();
            }
        catch(RóżnaDługośćWektorów b)
            {
            }

        Wektor<Wymierne> w5 = new Wektor<Wymierne>(new Wymierne(3,2), new Wymierne(7,3));
        Wektor<Wymierne> w6 = new Wektor<Wymierne>(new Wymierne(6,4), new Wymierne(7,3));
        try
            {
            Wymierne ilo56 = w5.iloczyn_skalarny(w6);
            ilo56.wypisz();
            }
        catch(RóżnaDługośćWektorów c)
            {
            }

        try
            {
            Wektor<Calkowite> sumw1w2 = w1.suma_wektorów(w2);
            sumw1w2.wypisz();
            }
        catch(RóżnaDługośćWektorów d)
            {
            }

        try
            {
            Wektor<Zmiennoprzecinkowe> sumw3w4 = w3.suma_wektorów(w4);
            sumw3w4.wypisz();
            }
        catch(RóżnaDługośćWektorów e)
            {
            }

        try
            {
            Wektor<Wymierne> sumw5w6 = w5.suma_wektorów(w6);
            sumw5w6.wypisz();
            }
        catch(RóżnaDługośćWektorów f)
            {
            }
        }
    }
