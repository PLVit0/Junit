package pl.kurs.osoba_it1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws NoOldestException, NoWomanException {

        // Stwórz klase osoba, osoba ma imie, miasto, wiek i napisz ponizsze metody // DONE

        // policz ile jest osob starszych niz podany wiek // DONE

        //znajdz najstarsza osobe z listy, jesli nie ma to rzuc wyjatkiem NoOldestException // DONE

        //znajdz najstarsza kobiete, jesli takiej ni ema to rzuc wyjatkiem NoWomenException / DONE

        //zwroc liste mezcyzzn // DONE

        //oblicz sredni wiek mezczyzn //DONE

        // * - metode ktora agreguje dwie metody powyzej (tzn: jako drugi parametr
        // przyjmuje funkcje ktora okresla plec) // ???

        //  metode ktora zwroci wszystkie rozne miasta z listy osob(rozne tzn: bez powtorzen) // DONE

        // metode ktora znajdze miasto w ktorym zyje najwiecej ludzi // DONE

        Osoba osoba1 = new Osoba("Tomek", "Warszawa", 30);
        Osoba osoba2 = new Osoba("Alan", "Lodz", 40);
        Osoba osoba3 = new Osoba("Jan", "Torun", 20);
        Osoba osoba4 = new Osoba("Zofia", "Lodz", 50);

        List<Osoba> listaOsob = new ArrayList<>(List.of(osoba1,osoba2,osoba3,osoba4));

        System.out.println(Osoba.ileStarszych(listaOsob,32));
        System.out.println(Osoba.najstarsza(listaOsob));
        System.out.println(Osoba.najstarszaKobieta(listaOsob));
        System.out.println(Osoba.listaMezczyzn(listaOsob));
        System.out.println(Osoba.sredniWiek(listaOsob));
        System.out.println(Osoba.sredniWiekMezczyzn(listaOsob, Predicate.not(u->u.getImie().endsWith("a"))));
        System.out.println(Osoba.listaMiast(listaOsob));
        System.out.println(Osoba.najpopularniejszeMiasto(listaOsob));
    }
}
