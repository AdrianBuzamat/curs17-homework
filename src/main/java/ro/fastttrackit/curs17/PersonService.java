package ro.fastttrackit.curs17;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService {
    private List<Person> persons = new ArrayList<>(List.of());

    public PersonService(List<Person> persons) {
        if (persons == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.persons.addAll(persons);
    }

    public List<String> allPersonNames() {
        List<String> result = persons.stream()
                .map(person -> String.join(" ", person.firstName(), person.lastName()))
                .collect(Collectors.toList());
        return result;
    }

    public List<Person> allMajorPersons() {
        List<Person> result = persons.stream()
                .filter(person -> person.age() > 18)
                .collect(Collectors.toList());
        return result;
    }

    public List<Person> allPersonsFromOradea() {
        List<Person> result = persons.stream()
                .filter(person -> person.city().equalsIgnoreCase("Oradea"))
                .collect(Collectors.toList());
        return result;
    }

    public List<String> allFirstNamesCapitalized() {
        List<String> result = persons.stream()
                .map(person -> person.firstName().toUpperCase())
                .collect(Collectors.toList());
        return result;
    }

    public List<String> allFirstNamesFirstLetterLastName() {
        List<String> result = persons.stream()
                .map(person -> String.join("", person.firstName(), " ", person.lastName().substring(0, 1), "."))
                .collect(Collectors.toList());
        return result;
    }

    public List<Person> allPersonsBetween18And60() {
        List<Person> result = persons.stream()
                .filter(person -> person.age() < 60)
                .filter(person -> person.age() > 18)
                .collect(Collectors.toList());
        return result;
    }

    //
//- list all persons having first name starting with A
    public List<String> allFirstNamesStartingWithA() {
        List<String> result = persons.stream()
                .map(person -> String.join("", "A", person.firstName()))
                .collect(Collectors.toList());
        return result;
    }
//- list all first names UNIQUELY
//
//- sort the persons by first name
public List<Person> sortedByFirstName() {
    List<Person> result = persons.stream()
            .sorted(Comparator.comparing(Person::firstName))
            .collect(Collectors.toList());
    return result;
}

//- sort the persons by last name
//
//- sort the persons by first name, last name and then age
}
