package se.lexicon;

import se.lexicon.model.Person;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationsDemo {

  public static void main(String[] args) {

    ex9();

  }


  // Terminal Operations

  // count()
  public static void ex1() {
    Stream<String> programmingLanguages = Stream.of("Java", "C#", "Python", "C++");
    long result = programmingLanguages.count();
    System.out.println(result); // 4
  }

  // Max & Min
  public static void ex2() {
    List<Integer> numbers = Arrays.asList(2, 100, 1, 12, 100000, 20000);

    Optional<Integer> maxOptional1 = numbers.stream().max((o1, o2) -> {
              if (o1 > o2) return 1;
              else if (o1 < o2) return -1;
              else return 0;
            }
    );

    Optional<Integer> maxOptional2 = numbers.stream().max((o1, o2) -> o1.compareTo(o2));
    Optional<Integer> maxOptional3 = numbers.stream().max(Integer::compareTo);

    if (maxOptional3.isPresent())
      System.out.println(maxOptional3.get());
    else
      System.out.println("-");
  }


  // findFirst()
  public static void ex3() {
    List<String> names = Arrays.asList("Niclas", "Erik", "Ulf", "Kent", "Fredrik");

    //String name = names.stream().filter(s -> s.equals("TEST")).findFirst().orElseThrow(() -> new IllegalArgumentException("Name was not valid"));

    Optional<String> optional = names.stream().filter(s -> s.equals("TEST")).findFirst();
    if (optional.isPresent()) System.out.println(optional.get());

  }

  public static void ex4() {
    List<String> names = Arrays.asList("Niclas", "Erik", "Ulf", "Kent", "Fredrik");
    Predicate<String> checkLength = name -> name.length() > 5;

    System.out.println(names.stream().allMatch(checkLength)); //  false
    System.out.println(names.stream().anyMatch(checkLength)); //  true
    System.out.println(names.stream().noneMatch(checkLength)); //  false


  }

  // collect()
  public static void ex5() {
    List<String> names = Arrays.asList("Niclas", "Erik", "Ulf", "Kent", "Fredrik", "Marcus", "Mehrdad");

    List<String> filteredName = names.stream()
            .filter(name -> name.startsWith("M"))
            .filter(name -> name.endsWith("d"))
            .collect(Collectors.toList());

    //filteredName.forEach(n -> System.out.println(n));
    filteredName.forEach(System.out::println);
  }


  // Intermediate Operations
  // filter
  public static void ex6() {
    List<String> names = Arrays.asList("Niclas", "Erik", "Ulf", "Kent", "Fredrik", "Marcus", "Mehrdad");
    names.stream()
            .filter(name -> name.startsWith("M"))
            .filter(name -> name.endsWith("d"))
            .forEach(System.out::println);
  }

  public static void ex7() {
    Stream<Integer> integerStream = Stream.iterate(1, i -> i + 1);
    integerStream.limit(20).forEach(System.out::println);
  }

  public static void ex8() {
    List<String> names = Arrays.asList("Niclas", "Erik", "Ulf", "Kent", "Fredrik", "Marcus", "Mehrdad");
    names.stream().skip(3).limit(2).forEach(System.out::println); //  "Kent", "Fredrik"
  }


  // sorted()
  public static void ex9() {
    List<Person> personList = new ArrayList<>();
    personList.add(new Person(1, "Mehrdad", "Javan", LocalDate.parse("1989-02-27"), false));
    personList.add(new Person(2, "Marcus", "Gudmundsen", LocalDate.parse("1985-04-14"), false));
    personList.add(new Person(3, "Simon", "Elbrink", LocalDate.parse("1994-10-28"), false));

    Comparator<Person> personComparatorLambda = (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName());
    Comparator<Person> personComparatorMR = Comparator.comparing(Person::getFirstName);

    personList.stream()
            .sorted(personComparatorMR)
            .forEach(System.out::println);

  }

}
