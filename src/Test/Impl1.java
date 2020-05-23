package Test;

import java.util.ArrayList;
import java.util.List;

public class Impl1 {

    //fields: int age, salary; String name;
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

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Name1", 54, 30000));
        personList.add(new Person("Name2", 24, 34000));
        personList.add(new Person("Name3", 14, 45000));
        testPredicate(personList);
    }

    private static void testPredicate(List<Person> personList) {
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
        System.out.println(findAll(personList, a.and(a1)));
    }


    public static <T> List<T> findAll(List<T> list, A<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        list.forEach(element -> {
            if (predicate.method(element))
                filteredList.add(element);
        });
        return filteredList;
    }
}
