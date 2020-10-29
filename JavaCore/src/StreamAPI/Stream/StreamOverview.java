package StreamAPI.Stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOverview {

    static class Person implements Comparable<Person>{
        private int id;
        private String name;
        private String lastName;
        private int salary;


        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

                @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            return this.id == ((Person) obj).id;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", salary=" + salary +
                    '}';
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getLastName() {
            return lastName;
        }

        public int getSalary() {
            return salary;
        }

        public Person(int id, String name, String lastName, int salary) {
            this.id = id;
            this.name = name;
            this.lastName = lastName;
            this.salary = salary;
        }

        @Override
        public int compareTo(Person o) {
            return Integer.compare(id, o.id);
        }
    }

    static Map<Integer, Person> map;
    static List<Person> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        list.add(new Person(1,"Viktor", "Hendriks", 4000));
        list.add(new Person(1,"Alex", "Hendriks", 5000));
        list.add(new Person(3,"Petr", "Hendriks", 6000));
        list.add(new Person(3,"Hoakin", "Larson", 7000));
        list.add(new Person(7,"Sam", "Larson", 4500));
        list.add(new Person(8,"Bud", "Larson", 3000));
        testFromList(list);
        testFromFile(new File("C:\\Users\\vzvz4\\Desktop\\PAPKA\\GitHub\\FormatterEx\\src\\Lambda\\Stream\\file.txt"));
    }

    static void testFromList(List<Person> list) {
        Integer[] ids = {8,7};
        Stream.of(ids)
                .map(StreamOverview::findById)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    static void testFromFile(File file) throws IOException {
        Files.lines(file.toPath())
                .map(String::toUpperCase)
                .filter(x -> x.length() > 4)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    static Person findById(int id) {
        if (map == null)
            map = list.stream()
                    .distinct()
                    .collect(Collectors.toMap(Person::getId, e -> e));
        return map.get(id);
    }

}
