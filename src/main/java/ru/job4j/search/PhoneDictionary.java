package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predicateName = x -> x.getName().contains(key);
        Predicate<Person> predicateSurname = x -> x.getSurname().contains(key);
        Predicate<Person> predicatePhone = x -> x.getPhone().contains(key);
        Predicate<Person> predicateAddress = x -> x.getAddress().contains(key);
        var combine = predicateName.or(predicateSurname)
                .or(predicatePhone).or(predicateAddress);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
