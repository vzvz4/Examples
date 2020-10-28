package WraperString;

import java.util.List;
import java.util.stream.Collectors;

public class DictionaryBuilder {
    public static void buildDictionary(String text) {
        text = text.toLowerCase();
        int[] result = new int['я' - 'а' + 1];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'а' && ch <= 'я')
                result[ch - 'а']++;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 0)
            System.out.println((char) (i + 'а') + " = " + result[i]);
        }
    }

    private static void countByLambda(List<String> list) {
            list.stream()
            .parallel()
            .flatMap(x -> x.chars().mapToObj(c -> (char) c))
            .filter(Character::isLowerCase)
            .collect(Collectors.groupingBy(Character::new, Collectors.counting()))
            .forEach((key, value) -> System.out.println(key + " " + value));
    }

    public static void main(String[] args) {
        buildDictionary("цвввфу");
        //output:
        //в = 1
        //у = 1
        //ф = 1
        //ц = 1
    }
}
