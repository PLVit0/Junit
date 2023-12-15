package pl.kurs.task.service;

import pl.kurs.task.model.Person;

import java.util.*;
import java.util.stream.Collectors;

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
    public String findMostPopularCity(List<Person> list){
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow();
    }

    //countAverageAge
    public static double countAverageAge(List<Person> list){
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.averagingDouble(Person::getAge));
    }



}
