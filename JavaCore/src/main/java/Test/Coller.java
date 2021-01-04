package Test;

import java.util.*;

public class Coller {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("S", "1");
        map.put("C", "2");
        map.put("B", "3");

        HashMap<String, String> map2 = new HashMap<>();
        map.put("G", "4");
        map.put("H", "5");
        map.put("J", "6");

        List<Map<String, String>> l = new ArrayList<>();
        l.add(map);
        l.add(map2);

        List<String> argsList = new ArrayList<>();
        argsList.add("S");

        l.forEach(x -> {
            if (x.keySet().containsAll(argsList))
                argsList.forEach(i -> System.out.println(x.get(i)));
        });

    }
}
