package pl.kurs.task.service;

import org.junit.Before;
import org.junit.Test;
import pl.kurs.task.model.Person;
import pl.kurs.task.model.Sex;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class PersonServiceTest {

    private Person person;
    private Person person1;
    private Person person2;
    private Person person3;
    private List<Person> personList;
    private PersonService personService;

    @Before
    public void init() {
        person = new Person("kamil", "wawa", 28, Sex.MALE);
        person1 = new Person("ala", "rzeszow", 48, Sex.FEMALE);
        person2 = new Person("witek", "lodz", 35, Sex.MALE);
        person3 = new Person("remek", "wawa", 35, Sex.MALE);
        personList = Arrays.asList(person, person1, person2, person3);
        personService = new PersonService();
    }

    @Test
    public void shouldReturnOldestPerson(){

        assertEquals(person1, personService.findTheOldestPerson(personList));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnNoSuchElementException() {
        Person oldest = personService.findTheOldestPerson(null);
    }

    @Test
    public void shoouldReturnTheMostPopularCity(){
        assertEquals("wawa", personService.findMostPopularCity(personList));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnNoSuchElementExceptionInMethodFindingMostPopularCityNull(){
        String mostPopularCity = personService.findMostPopularCity(null);
    }

    @Test
    public void shouldReturnTheMostPopularCityCorrectlyIfExpectedIsWrongValue(){
        assertNotEquals("lodz", personService.findMostPopularCity(personList));
    }

    @Test
    public void shouldReturCorrectValueOfAverageAge(){
        assertEquals(36.5, PersonService.countAverageAge(personList), 0.1 );
    }

    @Test
    public void shouldCheckIfThereIsIncorrectValueFromCountingAverageAge(){
        assertNotEquals(37, PersonService.countAverageAge(personList));
    }

    @Test
    public void shouldCheclIfThereIsNullValueFromCountingAverageAge(){
        assertNotEquals(null, PersonService.countAverageAge(personList));
    }


}