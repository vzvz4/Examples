package StreamAPI.Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortAndReduce {
    static class Person {
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(33, "Jimm"));
        list.add(new Person(12, "Hank"));
        list.add(new Person(56, "Hagrid"));
        list.add(new Person(15,"Timm"));

        Person p = list.stream().min(Comparator.comparingInt(x -> x.age)).get();
        list.stream()
                .sorted(Comparator.comparing(x -> x.name))
                .forEach(System.out::println);

        Person person = new Person(0, "");
        Person x = list.stream()
                .reduce(person, (x1, x2) -> {
                  x1.name = x1.name.concat(x2.name);
                  x1.age = x1.age + x2.age;
                  return x1;
                });
        System.out.println(x);
        System.out.println(p);
    }
}
