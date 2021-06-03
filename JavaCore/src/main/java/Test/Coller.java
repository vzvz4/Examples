package Test;

import java.util.*;

public class Coller {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("id", "2");
        map.put("name", "wallet");

        Map<String, List<String>> filter = new HashMap<>();
        filter.put("id", List.of("1", "2"));
        filter.put("name", List.of("hive"));

        for (Map.Entry<String, List<String>> entry : filter.entrySet()) {
            Optional<Map.Entry<String, String>> opt =
                    map.entrySet().stream()
                            .filter(x -> entry.getValue().contains(x.getValue().toString()))
                            .findAny();
            if (opt.isEmpty()) {
                System.out.println("Filtered");
                break;
            }
        }
    }
}
