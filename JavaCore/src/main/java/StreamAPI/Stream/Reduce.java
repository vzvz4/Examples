package StreamAPI.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {
    public static void main(String[] args) {
        //Метод reduce принимает  лямбда-выражение известное как аккумулятор (Accumulator),
        //которое служит для сворачивания данных в одну "кучу".

        List<Integer> numbers = Arrays.asList(1, 2, 3, 5);

        Optional<Integer> sum = numbers.stream()
                .reduce(Integer::sum);
        //сложить все числа
        sum.ifPresent(System.out::println); //output 11

        //сложить все числа начиная с 10
        Integer sum2 = numbers.stream()
                .reduce(10, Integer::sum);

        System.out.println(sum2); //output 21

        Integer min = numbers.stream()
                .reduce(Integer.MAX_VALUE, (left, right) -> left < right ? left : right);

        List<String> strings = Arrays.asList("aaa", "bbb", "ccc", "ddd", "ffff");
        String s = strings.stream()
                .reduce("", (left, right) -> left.length() > right.length() ? left : right);
    }
}
