package pl.kurs.osoba_it1;

import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Osoba {
    private String imie;
    private String miasto;
    private int wiek;

    public Osoba(String imie, String miasto, int wiek) {
        this.imie = imie;
        this.miasto = miasto;
        this.wiek = wiek;
    }

    public static long ileStarszych(List<Osoba> lista, int ileLat) {
        return lista.stream()
                .filter(u -> u.getWiek() > ileLat)
                .count();
    }

    public static Osoba najstarsza(List<Osoba> lista) throws NoOldestException {
        return lista.stream()
                .max(Comparator.comparing(Osoba::getWiek))
                .orElseThrow(NoOldestException::new);
    }
    public static Osoba najstarszaKobieta(List<Osoba> lista) throws NoWomanException{
        return lista.stream()
                .filter(u -> u.getImie().endsWith("a"))
                .max(Comparator.comparing(Osoba::getWiek))
                .orElseThrow(NoWomanException::new);
    }
    public static List<Osoba> listaMezczyzn(List<Osoba> lista){
        return lista.stream()
                .filter(Predicate.not(u->u.getImie().endsWith("a")))
                .collect(Collectors.toList());
    }
    public static OptionalDouble sredniWiek(List<Osoba> lista){
        return lista.stream()
                .filter(Predicate.not(u->u.getImie().endsWith("a")))
                .mapToDouble(u -> u.getWiek())
                .average();
    }
    public static Double sredniWiekMezczyzn(List<Osoba> lista, Predicate<Osoba> plec){
        return lista.stream()
                .filter(Objects::nonNull)
                .filter(plec)
                .collect(Collectors.averagingDouble(Osoba::getWiek));
    }
    public static List<String> listaMiast(List<Osoba> lista){
        return lista.stream()
                .filter(Objects::nonNull)
                .filter(o -> o.getMiasto() != null)
                .map(s->s.getMiasto())
                .distinct()
                .collect(Collectors.toList());
    }
    public static String najpopularniejszeMiasto(List<Osoba> lista){
        return lista.stream()
                .filter(Objects::nonNull)
                .filter(o -> o.getMiasto() != null)
                .collect(Collectors.groupingBy(Osoba::getMiasto, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow();
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + imie + '\'' +
                ", miasto='" + miasto + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}
