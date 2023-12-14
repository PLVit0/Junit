package pl.kurs.task.service;

import pl.kurs.task.model.Person;

import java.util.*;

public class PersonService {
    public Person findTheOldestPerson(List<Person> list){
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Person::getAge))
                .orElseThrow();
    }

    //findMostPopularCity


    //countAverageAge
}
