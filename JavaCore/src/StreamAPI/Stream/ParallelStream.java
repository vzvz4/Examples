package StreamAPI.Stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStream {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //Паралельные стримы
        List<Integer> list = numbers.parallelStream()
                .filter(x -> x > 10)
                .map(x -> x * 2)
                .collect(Collectors.toList());

        int a = IntStream.range(0, 10)
                .parallel()
                .map(x -> x * 10)
                .sum();

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers2.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList()); //или Collectors.toSet(); и тд
        System.out.println(evenNumbers); //output [2, 4, 6, 8, 10]

        List<String> names4 = Arrays.asList("Jaime", "Daenerys", "", "Tyrion", "");
        Queue<String> queue = names4.stream()
                .filter(n -> !n.isEmpty())
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(queue); //output [Jaime, Daenerys, Tyrion]
    }

}
