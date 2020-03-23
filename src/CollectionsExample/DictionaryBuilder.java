package CollectionsExample;

import java.util.LinkedHashMap;
import java.util.Map;

public class DictionaryBuilder {
    private static final String[] INPUT_DATA = {
            "a",
            "b", "b", "b",
            "c",
            "d",
            "e", "e",
            "f",
            "g", "g", "g",
            "h",
            "g",
            "i"
    };
    public static void main(String[] args) {
        Map<String, Integer> frequencyByWord = new LinkedHashMap<>();
   
        for (String word : INPUT_DATA) {
//            Integer frequency = frequencyByWord.get(word);
//            if (frequency == null) {
//                frequency = 0;
//            }
//            frequencyByWord.put(word, ++frequency);

//            Integer frequency = frequencyByWord.getOrDefault(word, 0);
//            frequencyByWord.put(word, frequency + 1);
//
//            frequencyByWord.merge(word, 1, new BiFunction<Integer, Integer, Integer>() {
//                @Override
//                public Integer apply(Integer oldValue, Integer newValue) {
//                    return oldValue + newValue;
//                }
//            });
//            frequencyByWord.merge(word, 1, (oldValue, newValue) -> oldValue + newValue);
            frequencyByWord.merge(word, 1, Integer::sum);
        }

//        for (String word : frequencyByWord.keySet()) {
//            Integer frequency = frequencyByWord.get(word);
//            System.out.println(word + ": " + frequency);
//        }

        frequencyByWord.forEach((word, frequency) -> {
            System.out.println(word + ": " + frequency);
        });
    }
}
