package StreamAPI.Stream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindCountOfRepeatedNumbers {
  public static void main(String[] args) throws IOException {

    List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(1);
        list.add(1);

    int max = list.stream()
        .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
        .values()
        .stream()
        .mapToInt(Math::toIntExact)
        .max()
        .getAsInt();

    System.out.println(max);
  }
}
