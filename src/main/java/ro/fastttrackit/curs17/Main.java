package ro.fastttrackit.curs17;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonService personService = new PersonService(List.of(
                new Person("Bogdan", "Ciugureanu", 33, "Oradea"),
                new Person("Dragos", "Axinte", 67, "Cluj"),
                new Person("Adrian", "Domniteanu", 37, "Oradea"),
                new Person("Catalin", "Bojog", 28, "Cluj"),
                new Person("Camelia", "Mandru", 44, "Oradea"),
                new Person("Ana", "Margarit", 15, "Cluj"),
                new Person("Ionut", "Pandele", 43, "Cluj"),
                new Person("Ionut", "Harjoghe", 12, "Fetesti")
        ));

        System.out.println(personService.allPersonsFromOradeaOrCluj());


    }
}
