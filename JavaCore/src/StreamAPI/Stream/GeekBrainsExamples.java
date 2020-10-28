package StreamAPI.Stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GeekBrainsExamples {
  public static void main(String[] args) throws IOException {
    //Найти строку по ключевому слову
    String path = "C:\\";
    Path p = Paths.get(path);
    String keyWord = "java";
    Files.lines(p).filter((line) -> line.contains(keyWord)).findAny();


    String[] array = {"Aaa", "Bbbbb", "Cc", "Aa"};
    System.out.println(Arrays.stream(array)
        .filter(str -> str.startsWith("A"))
        .collect(Collectors.joining(" и ", "Перечисленные слова [", "] начинаются на букву A")));

    //наибольшее значение в стриме
    Stream<Integer> stream = Stream.of(1, 2, 3, 24, 5, 6);
    stream.reduce(Math::max)
        .ifPresent(System.out::println);
    ///
    Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
        .filter(s -> {
          System.out.println("Фильтр: " + s);
          return true;
        }).forEach(s -> System.out.println("Результат: " + s));

    ///
    Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
        .filter(s -> {
          System.out.println("filter: " + s);
          return s.startsWith("a");
        })
        .map(s -> {
          System.out.println("map: " + s);
          return s.toUpperCase();
        })

        .forEach(s -> System.out.println("forEach: " + s));

    ///
    Stream<String> stream2 = Stream.of("a1", "b2", "a3", "c4", "d5")
        .filter(s -> s.startsWith("d"));
    stream2.anyMatch(s -> true);     // Пройдёт без проблем
//    stream.noneMatch(s -> true); error

    ///
    ForkJoinPool commonPool = ForkJoinPool.commonPool();
    System.out.println(commonPool.getParallelism());

    //Parallel
    Arrays.asList("a1", "a2", "b1", "c2", "c1")
        .stream()
        .filter(s -> {
          System.out.format("filter: %s [%s]\n",
              s, Thread.currentThread().getName());
          return true;
        })
//        .map(s -> {
//          System.out.format("map: %s [%s]\n",
//              s, Thread.currentThread().getName());
//          return s.toUpperCase();
//        })
        .forEach(s -> System.out.format("forEach: %s [%s]\n",
            s, Thread.currentThread().getName()));

    //
    Arrays.asList("a1", "a2", "b1", "c2", "c1")
        .stream()
//        .parallel()
        .filter(s -> {
          System.out.format("filter: %s [%s]\n",
              s, Thread.currentThread().getName());
          return true;
        })
        .map(s -> {
          System.out.format("map: %s [%s]\n",
              s, Thread.currentThread().getName());
          return s.toUpperCase();
        })
        .sorted((s1, s2) -> {
          System.out.format("sort: %s <> %s [%s]\n",
              s1, s2, Thread.currentThread().getName());
          return s1.compareTo(s2);
        })
        .forEach(s -> System.out.format("forEach: %s [%s]\n",
            s, Thread.currentThread().getName()));

  }
}
