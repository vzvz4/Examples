package Test;

import java.util.*;

public class Note {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Jhon", "", null, "Alex", "Constatin"));
        names.stream()
                .filter(s -> s != null && !s.isEmpty())
                .filter(s -> s.startsWith("A"))
                .forEach(System.out::println);
        System.out.println(check("The quick brown fox jumps over the lazy dog."));
    }

    public static boolean check(String sentence) {
        sentence = sentence.toLowerCase();
        char[] letters = sentence.toCharArray();
        char[] alphabet = new char['z' - 'a' + 1];
        int[] result = new int[alphabet.length];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) ('a' + i);
        }
        for (char letter : letters) {
            for (int j = 0; j < alphabet.length; j++) {
                if (letter >= 'a' && letter <= 'z') {
                    if (letter == alphabet[j])
                        result[j]++;
                }
            }
        }
        int count = 0;
        for (int res : result) {
            System.out.println(alphabet[count++] + ":" +res);
            if (res == 0)
                return false;
        }

        return true;
    }

    public static boolean check2(String sentence){
        for (char i = 'a'; i <='z'; i++)
            if (!sentence.toLowerCase().contains("" + i))
                return false;
        return true;

    }
    public static boolean check3(String sentence) {
        return sentence.chars().map(Character::toLowerCase).filter(Character::isAlphabetic).distinct().count() == 26;
    }

}