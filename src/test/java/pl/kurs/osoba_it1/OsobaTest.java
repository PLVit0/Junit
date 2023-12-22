package pl.kurs.osoba_it1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class OsobaTest {

    private Osoba osoba;
    private Osoba osoba1;
    private Osoba osoba2;
    private Osoba osoba3;

    private List<Osoba> listaOsob;

    @Before
    public void init(){
        osoba = new Osoba("Rafal", "Warszawa", 34);
        osoba2 = new Osoba("Edek", "Czestochowa", 33);
        osoba1 = new Osoba("Zuzanna", "Lublin", 23);
        osoba3 = new Osoba("Kamila", "Lublin", 23);
        listaOsob = Arrays.asList(osoba, osoba1, osoba2, osoba3);
    }

    @Test
    public void shouldReturnHowManyPeopleAreOlderThenAge22(){
        assertEquals(4, Osoba.ileStarszych(listaOsob, 22));
    }

    @Test
    public void shouldCountCorrectNumberOfPeopleOlderThanGivenAge(){
        assertNotEquals(3, Osoba.ileStarszych(listaOsob, 22));
    }

    @Test
    public void shouldNotReturnNullWhenCountingPeopleOlderThanGivenAge(){
        assertNotNull(Osoba.ileStarszych(listaOsob, 22));
    }

    @Test
    public void shouldReturnTheOldestPerson() throws NoOldestException {
        assertEquals(osoba, Osoba.najstarsza(listaOsob));
    }

    @Test(expected = NoOldestException.class)
    public void shouldReturnNoOldestExceptionWhenThereInNoOldestPerson() throws NoOldestException {
        List<Osoba> emptyList = new ArrayList<>();
        assertEquals(0, Osoba.najstarsza(emptyList));
    }

    @Test
    public void shouldNotReturnNullWhenWeWantToFindOldestPerson() throws NoOldestException {
        assertNotNull(Osoba.najstarsza(listaOsob));
    }

    @Test
    public void shouldReturnTheOldestWoman() throws NoWomanException {
        assertEquals(osoba1, Osoba.najstarszaKobieta(listaOsob));
    }

    @Test
    public void shouldNotReturnNullWhenWeWantToFindTheOldestWoman() throws NoWomanException {
        assertNotNull(Osoba.najstarszaKobieta(listaOsob));
    }

    @Test
    public void shouldNotReturnOldestWomenWhenGivenExpectedIsNotCorrect() throws NoWomanException {
        assertNotEquals(osoba, Osoba.najstarszaKobieta(listaOsob));
    }

    @Test
    public void shouldReturnListOfMensFromList(){
        List<Osoba> chlopy = Arrays.asList(osoba, osoba2);
        assertEquals(chlopy, Osoba.listaMezczyzn(listaOsob));
    }

    @Test
    public void shouldNotReturnListOfMensIfInListThereAreWomans(){
        List<Osoba> boysAndGirls = Arrays.asList(osoba,osoba1);
        assertNotEquals(boysAndGirls, Osoba.listaMezczyzn(listaOsob));
    }
    @Test
    public void shouldReturnCorrectValueOfAverageAge(){
        assertEquals(33.5, Osoba.sredniWiek(listaOsob), 0.1);
    }

    @Test
    public void shouldCheckIfThereIsIncorrectValueFromCountingAverageAge(){
        assertNotEquals(70, Osoba.sredniWiek(listaOsob));
    }

    @Test
    public void shouldCheckIfThereIsNullValueFromCountingAverageAge(){
        assertNotEquals(null, Osoba.sredniWiek(listaOsob));
    }

    @Test
    public void shouldReturnCorrectAverageAgeForMales() {
        List<Osoba> males = Arrays.asList(osoba, osoba2);
        assertEquals(33.5, Osoba.sredniWiekMezczyzn(males, Predicate.not(u->u.getImie().endsWith("a"))), 0.1);
    }

    @Test
    public void shouldReturnMostPopularCity() {
        assertEquals("Lublin", Osoba.najpopularniejszeMiasto(listaOsob));
    }

}