package se.lexicon;

import se.lexicon.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StreamDemo {

  public static void main(String[] args) {

    List<Person> personList = new ArrayList<>();
    personList.add(new Person(1, "Mehrdad", "Javan", LocalDate.parse("1989-02-27"), false));
    personList.add(new Person(2, "Marcus", "Gudmundsen", LocalDate.parse("1985-04-14"), false));
    personList.add(new Person(3, "Simon", "Elbrink", LocalDate.parse("1994-10-28"), false));

    Predicate<Person> leapYear = person -> person.getBirthDate().isLeapYear();
    Predicate<Person> firstNameStartWithM = person -> person.getFirstName().startsWith("M");
    Consumer<Person> printPersonInfo = person -> System.out.println(person.toString());

    personList.stream() // source
            .filter(person -> person.getFirstName().startsWith("M")) // intermediate operation
            .forEach(person -> System.out.println(person.getFirstName() + " " + person.getLastName())); // terminal operation

  }
}
