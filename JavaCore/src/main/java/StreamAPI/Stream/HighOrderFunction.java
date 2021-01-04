package StreamAPI.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HighOrderFunction {
    
    //Abstract class example
    static abstract class A <T> {
        abstract boolean method(T a);

        A<T> and(A<? super T> a) {
            return new A<T>() {
                @Override
                boolean method(T s) {
                    return /* ---> */ method(s) /* <--- */ && a.method(s);
                }
            };
        }
    }
    private static void testPredicateAbs(List<Person> personList) {
        A a = new A<Person>() {
            @Override
            boolean method(Person a) {
                return a.salary > 30000;
            }
        };
        A a1 = new A<Person>() {
            @Override
            boolean method(Person a) {
                return a.age < 50;
            }
        };
        System.out.println(findAllAbs(personList, a.and(a1)));
    }


    public static <T> List<T> findAllAbs(List<T> list, A<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        list.forEach(element -> {
            if (predicate.method(element))
                filteredList.add(element);
        });
        return filteredList;
    }


    static class Person {
        private String name;
        private int age;
        private int salary;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }

        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
        public int getSalary() {
            return salary;
        }

        public Person(String name, int age, int salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Danny", 54, 30000));
        personList.add(new Person("Alex", 24, 34000));
        personList.add(new Person("Marty", 14, 45000));
        testPredicate(personList);
        testFunction(personList);
        testConsumer(personList);
    }

    //boolean test(U u);
    public static void testPredicate(List<Person> list) {
        Predicate<Person> isRich = x -> x.salary > 30000;
        Predicate<Person> isOld = x -> x.age < 50;
        System.out.println(findAll(list, isOld.and(isRich)));
    }

    //R apply(T t);
    public static void testFunction(List<Person> list) {
        Function<Person, String> concat = x -> x.name + " age: " + x.age;
        Function<String, String> addAge = y -> y.concat(" Person");
        List<String> newList = transform(list, addAge.compose(concat));
        newList.forEach(System.out::println);

        Function<String, String> function = String::toUpperCase;
        Function<String, String> function1 = x -> x.concat("!!!");
        List<String> list1 = transform(newList, composeFunctions(function, function1));
        list1.forEach(System.out::println);
    }

    //void accept(T t);
    public static void testConsumer(List<Person> list) {
        Consumer<Person> riseSalary = x -> x.salary = x.salary + 500;
        list.forEach(riseSalary.andThen(System.out::println));
    }







    //объединяем функции
    private static <T> Function<T,T> composeFunctions (Function<T,T>... function) {
        Function<T,T> result = Function.identity();
        for (Function<T,T> f: function) {
            result = result.andThen(f);
        }
        return result;
    }

    //mapping - превращаем лист одного типа в лист другого типа
    public static <T,R> List<R> transform(List<T> elements, Function<T,R> function) {
        List<R> list = new ArrayList<>();
        elements.forEach(element -> list.add(function.apply(element)));
        return list;
    }

    public static <T> List<T> findAll(List<T> list, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        list.forEach(element -> {
            if (predicate.test(element))
                filteredList.add(element);
        });
        return filteredList;
    }
}
