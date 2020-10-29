package StreamAPI.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamFunctionPredicateEtc {
    static List<String> strings = new ArrayList<>(Arrays.asList("java","cpp","python","js"));

    static <T,R> int function(List<T> list, Function<T, Integer> func) {
        int sum = 0;
        for (T element : list) {
            sum += func.apply(element);
        }
        return sum;
    }

    static <T> T predicate(List<T> list, Predicate<T> funcPredicate) {
        for (T element : list) {
            if(funcPredicate.test(element))
                return element;
        }
        return null;
    }

    static <T,R> R combine(List<T> list,  R elementZero, Function<T, R> func, BinaryOperator<R> binaryOperator) {
        for (T element : list) {
            elementZero = binaryOperator.apply(elementZero, func.apply(element));
        }
        return elementZero;
    }

    static class Employee {
        private String name;
        private int salary;

        public String getName() {
            return name;
        }
        public int getSalary() {
            return salary;
        }

        public Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        System.out.println(function(strings, String::length));
        System.out.println(predicate(strings, x -> x.startsWith("j")));

        BinaryOperator<Integer> binaryOperator = Math::min;

        List<Employee> employees = new ArrayList<>(
                Arrays.asList(
                        new Employee("Jhon Abygale Campbot",4000),
                        new Employee("Carl la Costa rica", 3400),
                        new Employee("Proselyte", 3400),
                        new Employee("Andrey", 3400)
                ));
        int zero = employees.get(0).getName().length();
        System.out.println(combine(employees, zero, employee -> employee.getName().length(), Math::min));
    }
}
