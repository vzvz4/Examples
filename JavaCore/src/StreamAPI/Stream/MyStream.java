package StreamAPI.Stream;

import java.util.ArrayList;
import java.util.List;

public class MyStream<T> {
  private final T[] array;
  private final List<T> downStream;
  private int counter;
  private T element;

  @SuppressWarnings("unchecked")
  public MyStream(T[] array) {
    this.array = array;
    downStream = new ArrayList<>();
  }

  public static void main(String[] args) {
//    Arrays.stream(new String[]{"asd"}).forEach();
    MyStream<String> stream = new MyStream<>(new String[]{"1,2,3,4", "wa", "dwa", "ads", "w"});
    stream
        .filter(x -> x.length() > 2)
        .forEach(System.out::println);
  }

  @FunctionalInterface
  interface Predicate<T> {
    boolean test(T t);
  }

  @FunctionalInterface
  interface Consumer<T> {
    void consume(T t);
  }

  public MyStream<T> filter(Predicate<T> predicate) {
    element = array[counter++];
    if (predicate.test(element)) {
      downStream.add(element);
    }
    return this;
  }

  public void forEach(Consumer<T> consumer) {
    consumer.consume(element);
  }


}
