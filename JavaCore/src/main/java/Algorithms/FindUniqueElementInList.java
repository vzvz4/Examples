package Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindUniqueElementInList {
  public static void main(String[] args) {
    List<String> persons = new ArrayList<>();
    persons.add("Greg");
    persons.add("Greg");
    persons.add("Max");
    persons.add("Oleg");
    persons.add("Greg");
    persons.add("Greg");
    persons.add("Oleg");
    persons.add("Oleg");
    persons.add("Alex");

    persons.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .forEach((x,y) -> System.out.println("Key - " + x + " : Value: - " + y));


    List<String> res = persons.stream()
        .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(e -> e.getValue() == 1)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());

    System.out.println(res);
  }


}
