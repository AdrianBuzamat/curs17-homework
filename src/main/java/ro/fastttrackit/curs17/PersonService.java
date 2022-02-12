package ro.fastttrackit.curs17;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService {
    private List<Person> persons = new ArrayList<>();

    public PersonService(List<Person> persons) {
        if (persons == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.persons.addAll(persons);
    }

    public List<String> allPersonNames() {
        return persons.stream()
                .map(person -> String.join(" ", person.firstName(), person.lastName()))
                .collect(Collectors.toList());
    }

    public List<Person> allMajorPersons() {
        return persons.stream()
                .filter(person -> person.age() > 18)
                .collect(Collectors.toList());
    }

    public List<Person> allPersonsFromOradea() {
        return persons.stream()
                .filter(person -> person.city().equalsIgnoreCase("Oradea"))
                .collect(Collectors.toList());
    }
    //list all persons from Oradea OR Cluj
    public List<Person> allPersonsFromOradeaOrCluj() {
        return persons.stream()
                .filter(PersonService::isFromOradeaOrCluj)
                .collect(Collectors.toList());
    }

    private static boolean isFromOradeaOrCluj(Person person) {
        return "Oradea".equalsIgnoreCase(person.city())
                || "Cluj".equalsIgnoreCase(person.city());
    }

    public List<String> allFirstNamesCapitalized() {
        return persons.stream()
                .map(person -> person.firstName().toUpperCase())
                .collect(Collectors.toList());
    }

    public List<String> allFirstNamesFirstLetterLastName() {
        return persons.stream()
                .map(person -> String.join("", person.firstName(), " ", person.lastName().substring(0, 1), "."))
                .collect(Collectors.toList());
    }

    public List<Person> allPersonsBetween18And60() {
        return persons.stream()
                .filter(person -> person.age() < 60)
                .filter(person -> person.age() > 18)
                .collect(Collectors.toList());
    }

    public List<Person> allFirstNamesStartingWithA() {
        return persons.stream()
                .filter(person -> person.firstName().startsWith("A") )
                .collect(Collectors.toList());
    }

    public List<String> allDistinctFirstName() {
        return persons.stream()
                .map(Person::firstName)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Person> sortedByFirstName() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::firstName))
                .collect(Collectors.toList());
    }

    public List<Person> sortedByLastName() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::lastName))
                .collect(Collectors.toList());
    }

    public List<Person> sortedBySeveralFilters() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::firstName))
                .sorted(Comparator.comparing(Person::lastName))
                .sorted(Comparator.comparing(Person::age))
                .collect(Collectors.toList());
    }
}
