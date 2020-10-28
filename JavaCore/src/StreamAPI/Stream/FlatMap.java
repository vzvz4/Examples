package StreamAPI.Stream;

import java.util.Arrays;

public class FlatMap {
    public static void main(String[] args) {
        String[] sta = "java is the best language in the world".split(" ");

        Arrays.stream(sta)
                .flatMapToInt(CharSequence::chars)
                .distinct()
                .sorted()
                .forEach(x -> System.out.println((char)x));
        //output
        //a
        //d
        //c
        //...
    }
}
