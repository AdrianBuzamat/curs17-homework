package ro.fasttrackit.curs17;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ro.fastttrackit.curs17.Person;
import ro.fastttrackit.curs17.PersonService;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PersonServiceTest {
    @Test
    @DisplayName("WHEN a List of Persons is given THEN return a list of Strings with all names")
    void allPersonNamesTest() {
        List<Person> persons = List.of(
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Dragos", "Axinte", 67, "Cluj"),
                new Person("Adrian", "Domniteanu", 37, "Oradea"),
                new Person("Catalin", "Bojog", 28, "Cluj"),
                new Person("Ionut", "Pandele", 43, "Cluj"),
                new Person("Ionut", "Harjoghe", 12, "Fetesti")
        );
        PersonService personService = new PersonService(persons);
        List<String> result = Arrays.asList("Bogdan Ciugureanu",
                "Dragos Axinte",
                "Adrian Domniteanu",
                "Catalin Bojog",
                "Ionut Pandele",
                "Ionut Harjoghe");

        assertThat(personService.allPersonNames()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN a List of Persons is given THEN return a list of persons with all persons older than 18 years")
    void allMajorPersonTest() {
        List<Person> persons = List.of(
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Dragos", "Axinte", 67, "Cluj"),
                new Person("Adrian", "Domniteanu", 37, "Oradea"),
                new Person("Catalin", "Bojog", 28, "Cluj"),
                new Person("Ionut", "Pandele", 43, "Cluj"),
                new Person("Ionut", "Harjoghe", 12, "Fetesti")
        );
        PersonService personService = new PersonService(persons);
        List<Person> result = new ArrayList<>(List.of(
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Dragos", "Axinte", 67, "Cluj"),
                new Person("Adrian", "Domniteanu", 37, "Oradea"),
                new Person("Catalin", "Bojog", 28, "Cluj"),
                new Person("Ionut", "Pandele", 43, "Cluj")
        ));

        assertThat(personService.allMajorPersons()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN a List of Persons is given THEN return a list of persons with all persons from Oradea")
    void allPersonsFromOradeaTest() {
        List<Person> persons = List.of(
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Dragos", "Axinte", 67, "Cluj"),
                new Person("Adrian", "Domniteanu", 37, "Oradea"),
                new Person("Catalin", "Bojog", 28, "Cluj"),
                new Person("Ionut", "Pandele", 43, "Cluj"),
                new Person("Ionut", "Harjoghe", 12, "Fetesti")
        );
        PersonService personService = new PersonService(persons);
        List<Person> result = new ArrayList<>(List.of(
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Adrian", "Domniteanu", 37, "Oradea")
        ));

        assertThat(personService.allPersonsFromOradea()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN a List of Persons is given THEN return a list of persons with all persons from Oradea or Cluj")
    void allPersonsFromOradeaOrClujTest() {
        List<Person> persons = List.of(
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Dragos", "Axinte", 67, "Cluj"),
                new Person("Adrian", "Domniteanu", 37, "Oradea"),
                new Person("Catalin", "Bojog", 28, "Cluj"),
                new Person("Ionut", "Pandele", 43, "Cluj"),
                new Person("Ionut", "Harjoghe", 12, "Fetesti")
        );
        PersonService personService = new PersonService(persons);
        List<Person> result = new ArrayList<>(List.of(
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Dragos", "Axinte", 67, "Cluj"),
                new Person("Adrian", "Domniteanu", 37, "Oradea"),
                new Person("Catalin", "Bojog", 28, "Cluj"),
                new Person("Ionut", "Pandele", 43, "Cluj")
        ));

        assertThat(personService.allPersonsFromOradeaOrCluj()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN a List of Persons is given THEN return a list of Strings with all first names CAPITALIZED")
    void allFirstNamesCapitalizedTest() {
        List<Person> persons = List.of(
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Dragos", "Axinte", 67, "Cluj"),
                new Person("Adrian", "Domniteanu", 37, "Oradea")
        );
        PersonService personService = new PersonService(persons);
        List<String> result = Arrays.asList("BOGDAN",
                "DRAGOS",
                "ADRIAN");

        assertThat(personService.allFirstNamesCapitalized()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN a List of Persons is given THEN return a list of Strings with all first names and the first letter from last name")
    void allFirstNamesWFirstLetterFLastNameTest() {
        List<Person> persons = List.of(
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Dragos", "Axinte", 67, "Cluj"),
                new Person("Adrian", "Domniteanu", 37, "Oradea")
        );
        PersonService personService = new PersonService(persons);
        List<String> result = Arrays.asList("Bogdan C.",
                "Dragos A.",
                "Adrian D.");

        assertThat(personService.allFirstNamesWFirstLetterFLastName()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN a List of Persons is given THEN return a list of persons with age between 18 and 60")
    void allPersonsBetween18And60Test() {
        List<Person> persons = List.of(
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Dragos", "Axinte", 67, "Cluj"),
                new Person("Adrian", "Domniteanu", 12, "Oradea")
        );
        PersonService personService = new PersonService(persons);
        List<Person> result = new ArrayList<>(List.of(
                new Person("Bogdan", "Ciugureanu", 33, "Oradea")
        ));

        assertThat(personService.allPersonsBetween18And60()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN a List of Persons is given THEN return a list of persons with first name starting with A")
    void allFirstNamesStartingWithATest() {
        List<Person> persons = List.of(
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Dragos", "Axinte", 67, "Cluj"),
                new Person("Adrian", "Domniteanu", 12, "Oradea")
        );
        PersonService personService = new PersonService(persons);
        List<Person> result = new ArrayList<>(List.of(
                new Person("Adrian", "Domniteanu", 12, "Oradea")
        ));

        assertThat(personService.allFirstNamesStartingWithA()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN a List of Persons is given THEN return a list of Strings with all first names that are unique")
    void allDistinctFirstNameTest() {
        List<Person> persons = List.of(
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Dragos", "Axinte", 67, "Cluj"),
                new Person("Dragos", "Axinte", 67, "Cluj"),
                new Person("Adrian", "Domniteanu", 37, "Oradea"),
                new Person("Adrian", "Domniteanu", 37, "Oradea")
        );
        PersonService personService = new PersonService(persons);
        List<String> result = Arrays.asList("Bogdan",
                "Dragos",
                "Adrian");

        assertThat(personService.allDistinctFirstName()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN a List of Persons is given THEN return a list of persons sorted by first name")
    void sortedByFirstNameTest() {
        List<Person> persons = List.of(
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Dragos", "Axinte", 67, "Cluj"),
                new Person("Adrian", "Domniteanu", 12, "Oradea")
        );
        PersonService personService = new PersonService(persons);
        List<Person> result = new ArrayList<>(List.of(
                new Person("Adrian", "Domniteanu", 12, "Oradea"),
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Dragos", "Axinte", 67, "Cluj")
        ));

        assertThat(personService.sortedByFirstName()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN a List of Persons is given THEN return a list of persons sorted by last name")
    void sortedByLastNameTest() {
        List<Person> persons = List.of(
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Dragos", "Axinte", 67, "Cluj"),
                new Person("Adrian", "Domniteanu", 12, "Oradea")
        );
        PersonService personService = new PersonService(persons);
        List<Person> result = new ArrayList<>(List.of(
                new Person("Dragos", "Axinte", 67, "Cluj"),
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Adrian", "Domniteanu", 12, "Oradea")
        ));

        assertThat(personService.sortedByLastName()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN a List of Persons is given THEN return a list of persons sorted by first name, last name and then age")
    void sortedBySeverralFiltersTest() {
        List<Person> persons = List.of(
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Dragos", "Axinte", 67, "Cluj"),
                new Person("Adrian", "Domniteanu", 12, "Oradea"),
                new Person("Adrian", "Domniteanu", 6, "Oradea")
        );
        PersonService personService = new PersonService(persons);
        List<Person> result = new ArrayList<>(List.of(
                new Person("Adrian", "Domniteanu", 6, "Oradea"),
                new Person("Adrian", "Domniteanu", 12, "Oradea"),
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Dragos", "Axinte", 67, "Cluj")
        ));

        assertThat(personService.sortedBySeveralFilters()).isEqualTo(result);
    }
}
