package CollectionsExample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class App {

    public static void main(String[] args) {
        String[] str = {"tree", "apple", "stone", "apple", "stone", "fruit", "fruit", "lemon", "pool", "apple", "fruit", "fruit"};

        HashSet<String> sl = new HashSet<>(Arrays.asList(str));
        HashMap<String, Integer> hm = new HashMap<>();

        for (String s : sl) {
            int res = 1;
            for (String value : str) {
                if (s.toLowerCase().equals(value.toLowerCase()))
                    hm.put(s, res++);
            }
        }

        for (HashMap.Entry<String, Integer> o : hm.entrySet()) {
            if (o.getValue() > 1)
                System.out.println("Слово : " + o.getKey() + " - количтсво повторений: " + o.getValue());
            else
                System.out.println("Слово : " + o.getKey() + " - уникальное ");

        }
    }

}
